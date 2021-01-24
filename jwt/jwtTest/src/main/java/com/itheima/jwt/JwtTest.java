package com.itheima.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTest {

    public static void main(String[] args) {

        //获取系统的当前时间
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);

        //生成jwt令牌
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("66")//设置jwt编码
                .setSubject("黑马程序员")//设置jwt主题
                .setIssuedAt(new Date())//设置jwt签发日期
                //.setExpiration(date)//设置jwt的过期时间（如果使用当前时间 在生成令牌的瞬间就已经过期了）
                .claim("roles","admin") //自定义claim 用于在jwt中存储更多的自定义信息
                .claim("company","itheima") 
                .signWith(SignatureAlgorithm.HS256, "itheima");//设置签名 使用HS256算法，并设置SecretKey(字符串)

        //生成jwt
        String jwtToken = jwtBuilder.compact();
        System.out.println(jwtToken);

        //解析jwt,得到其内部的数据（解析jwt使用的签名 必须与生成jwt时使用的签名一致）
        Claims claims = Jwts.parser().setSigningKey("itheima").parseClaimsJws(jwtToken).getBody();
        System.out.println(claims);
    }
}
