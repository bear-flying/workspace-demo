package com.founder.util;

import java.security.MessageDigest;

public class SignUtils {

	public static String retSign(String appId, String appKey, String timeStamp) throws Exception {
		String input = "appId=" + appId + "&appKey=" + appKey + "&timeStamp=" + timeStamp;
		// 获得SHA-1摘要算法的 MessageDigest 对象
		MessageDigest mdInst = MessageDigest.getInstance("SHA-1");
		// 使用指定的字节更新摘要
		mdInst.update(input.getBytes());
		// 获得密文
		byte[] md = mdInst.digest();
		// 把密文转换成十六进制的字符串形式
		StringBuffer hexString = new StringBuffer();
		// 字节数组转换为 十六进制数
		String shaHex = null;
		for (int i = 0; i < md.length; i++) {
			shaHex = Integer.toHexString(md[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexString.append(0);
			}
			hexString.append(shaHex);
		}
		//System.out.println("sign=" + hexString.toString());
		return hexString.toString();
	}
	
	public static void main(String[] args) throws Exception {
		String appId = "719b592852264b6a";
		String appKey = "3aa4aeb08e62408ead1b5248bc3de799";
		String timeStamp = String.valueOf(System.currentTimeMillis());
		System.out.println(timeStamp);
		System.out.println(retSign(appId, appKey, timeStamp));
	}
	
}
