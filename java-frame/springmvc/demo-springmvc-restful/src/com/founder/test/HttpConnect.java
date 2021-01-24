package com.founder.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnect {

	// inputstream-->String
	public static String stream2string(InputStream in, String encode) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] b = new byte[2048];
		int len = 0;
		try {
			if (encode == null || encode.equals("")) {
				encode = "utf-8";
			}
			while ((len = in.read(b)) > 0) {
				out.write(b, 0, len);
			}
			return out.toString(encode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("name=xiao");
		URL url;
		String urlPath = "http://127.0.0.1:7060/MedicalNewspaper/hi/haha/1";
		try {
			byte[] entitydata = sb.toString().getBytes();
			url = new URL(urlPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(10 * 1000); // http请求连接超时
			conn.setReadTimeout(60 * 1000); // 设置http请求读取时间
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", String.valueOf(entitydata.length));
			OutputStream os = conn.getOutputStream();
			os.write(entitydata);
			os.flush();
			os.close();
			if (conn.getResponseCode() == 200) {
				System.out.println("done");
				InputStream in = conn.getInputStream();
				String result = stream2string(in, null);
				System.out.println(result);
				
			}
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
