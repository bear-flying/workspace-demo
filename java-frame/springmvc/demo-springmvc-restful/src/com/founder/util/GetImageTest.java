package com.founder.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @说明 从网络获取图片到本地
 * @author 
 * @version 1.0
 * @since
 */
public class GetImageTest {
	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String url = 
				"http://img-xhpfm.zhongguowangshi.com/News/201608/b0722062b88d47e4907a55891e37002b.jpg";
		byte[] btImg = getImageFromNetByUrl(url);
		if (null != btImg && btImg.length > 0) {
			System.out.println("读取到：" + btImg.length + " 字节");
			String fileName = "po.jpg";
			writeImageToDisk(btImg, fileName);
		} else {
			System.out.println("没有从该连接获得内容");
		}
	}

	/**
	 * 将图片写入到磁盘
	 * 
	 * @param img
	 *            图片数据流
	 * @param fileName
	 *            文件保存时的名称
	 */
	public static void writeImageToDisk(byte[] img, String fileName) {
		try {
			File file = new File("f:\\" + fileName);
			FileOutputStream fops = new FileOutputStream(file);
			fops.write(img);
			fops.flush();
			fops.close();
			System.out.println("图片已经写入到盘");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据地址获得数据的字节流
	 * 
	 * @param strUrl
	 *            网络连接地址
	 * @return
	 */
	public static byte[] getImageFromNetByUrl(String strUrl) {
		try {
			 System.setProperty("http.proxyHost", "isadz");
             System.setProperty("http.proxyPort", "80");
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			//conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();// 通过输入流获取图片数据
			byte[] btImg = readInputStream(inStream);// 得到图片的二进制数据
			return btImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 从输入流中获取数据
	 * 
	 * @param inStream
	 *            输入流
	 * @return
	 * @throws Exception
	 */
	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}
}