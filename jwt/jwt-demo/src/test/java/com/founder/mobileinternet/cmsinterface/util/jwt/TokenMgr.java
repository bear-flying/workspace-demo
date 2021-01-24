package com.founder.mobileinternet.cmsinterface.util.jwt;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import net.sf.json.JSONObject;

/**
 * 管理所有的Token
 */
public class TokenMgr {
	
	public static SecretKey generalKey(String publicKey) {
		try {
			//方式一：byte[] encodedKey = Base64.decode(Constant.JWT_SECERT); 引入com.sun.org.apache.xerces.internal.impl.dv.util.Base64
			//方式二：不管哪种方式最终得到一个byte[]类型的key就行
			byte[] encodedKey = publicKey.getBytes("UTF-8");
		    SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		    return key;
		} catch (Exception e) {
			e.printStackTrace();
			 return null;
		}
	}
	/**
	 * 签发JWT
	 * @param id  jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
	 * @param iss jwt签发者
	 * @param subject jwt所面向的用户
	 * @param ttlMillis 有效期,单位毫秒
	 * @return token
	 * @throws Exception
	 */
	public static String createJWT(String id,String iss, String subject, 
			long ttlMillis, String publicKey) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey secretKey = generalKey(publicKey);
		JwtBuilder builder = Jwts.builder()
				.setId(id)
				.setIssuer(iss)
				.setSubject(subject)
				.setIssuedAt(now)
				.signWith(signatureAlgorithm, secretKey);
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date expDate = new Date(expMillis);
			builder.setExpiration(expDate);
		}
		return builder.compact();
	}
	
	/**
	 * 验证JWT
	 * @param jwtStr
	 * @return
	 */
	public static CheckResult validateJWT(String jwtStr, String publicKey) {
		CheckResult checkResult = new CheckResult();
		Claims claims = null;
		try {
			claims = parseJWT(jwtStr, publicKey);
			checkResult.setSuccess(true);
			checkResult.setClaims(claims);
		} catch (ExpiredJwtException e) {
			checkResult.setErrCode(Constant.JWT_ERRCODE_EXPIRE);
			checkResult.setSuccess(false);
		} catch (SignatureException e) {
			checkResult.setErrCode(Constant.JWT_ERRCODE_FAIL);
			checkResult.setSuccess(false);
		} catch (Exception e) {
			checkResult.setErrCode(Constant.JWT_ERRCODE_FAIL);
			checkResult.setSuccess(false);
		}
		return checkResult;
	}
	
	/**
	 * 
	 * 解析JWT字符串
	 * @param jwt
	 * @return
	 * @throws Exception
	 */
	public static Claims parseJWT(String jwt, String publicKey) throws Exception {
		SecretKey secretKey = generalKey(publicKey);
		return Jwts.parser()
			.setSigningKey(secretKey)
			.parseClaimsJws(jwt)
			.getBody();
	}
	
	/**
	 * 生成subject信息
	 * @param user
	 * @return
	 */
	public static String generalSubject(SubjectModel sub){
		JSONObject json = JSONObject.fromObject(sub);
		return json.toString();
		//return GsonUtil.objectToJsonStr(sub);
	}
}