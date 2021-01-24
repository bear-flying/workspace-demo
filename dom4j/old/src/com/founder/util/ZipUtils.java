package com.founder.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 进行ZIP压缩处理的封装类
 * 
 * @author 齐明
 * @version 1.0 Date:2004-6-24
 */
public class ZipUtils {
	private ZipOutputStream out = null;

	public ZipUtils() {
	}

	public ZipUtils(OutputStream out) {
		this.setZipOutputStream(out);
	}

	/**
	 * 设置目标Zip文件的全路径名
	 * 
	 * @param filename
	 *            目标Zip文件的全路径名
	 * @throws IOException
	 */
	public void setZipFile(String filename) throws IOException {
		File file = new File(filename);
		FileOutputStream dest = new FileOutputStream(file);
		CheckedOutputStream checksum = new CheckedOutputStream(dest,
				new Adler32());
		out = new ZipOutputStream(new BufferedOutputStream(checksum));
	}

	/**
	 * 设置压缩输出流
	 * 
	 * @param os
	 *            输出流
	 */
	public void setZipOutputStream(OutputStream os) {
		CheckedOutputStream checksum = new CheckedOutputStream(os,
				new Adler32());
		out = new ZipOutputStream(new BufferedOutputStream(checksum));
	}

	/**
	 * 判断目标Zip文件是否存在
	 * 
	 * @param filename
	 *            目标文件的全路径名字
	 * @return 存在,true;不存在,false
	 */
	public boolean isZipExist(String filename) {
		File file = new File(filename);
		if (file.exists())
			return true;
		else
			return false;
	}

	/**
	 * 将参数包含的数据压缩进目标文件中
	 * 
	 * @param content
	 *            被压缩的数据内容
	 * @param entryname
	 *            在压缩包中文件的名字
	 * @throws IOException
	 */
	public void zipIntoTarget(byte[] content, String entryname)
			throws IOException {
		// 设置压缩方法
		out.setMethod(ZipOutputStream.DEFLATED);
		out.putNextEntry(new ZipEntry(entryname));
		out.write(content);
	}

	/**
	 * 压缩多个文件
	 * 
	 * @param filenames
	 *            被压缩的多个文件全路径名
	 * @throws IOException
	 */
	public void zipMultiFiles(String[] filenames) throws IOException {
		byte[] tmpContent = null;
		for (int i = 0; i < filenames.length; i++) {
			String entryname = filenames[i].substring(filenames[i]
					.lastIndexOf("/") + 1);
			tmpContent = readFile(filenames[i]);
			if (tmpContent != null && out != null)
				zipIntoTarget(tmpContent, entryname);
		}
	}

	/**
	 * 将多个输入流压缩，同时给出压缩内容中的文件名
	 * 
	 * @param is
	 *            输入流数组
	 * @param entryname
	 *            文件名数组
	 * @throws IOException
	 */
	public void zipMultiInputStream(InputStream[] is, String[] entryname)
			throws IOException {
		for (int i = 0; i < is.length; i++) {
			byte[] tmpContent = new byte[is[i].available()];
			is[i].read(tmpContent);
			if (tmpContent != null && out != null)
				zipIntoTarget(tmpContent, entryname[i]);
			tmpContent = null;
		}
		out.close();
	}

	/**
	 * 将多个输入流压缩，同时给出压缩内容中的文件名
	 * 
	 * @param is
	 *            输入流数组
	 * @param entryname
	 *            文件名数组
	 * @throws IOException
	 */
	public void zipMultiActiveInputStream(InputStream[] is, String[] entryname)
			throws IOException {
		for (int i = 0; i < is.length; i++) {
			byte[] tmpContent = new byte[is[i].available()];
			is[i].read(tmpContent);
			if (tmpContent != null && out != null)
				zipIntoTarget(tmpContent, entryname[i]);
			tmpContent = null;
		}
	}

	/**
	 * 关闭流
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		out.close();
	}

	/**
	 * 将指定内容输出至文件
	 * 
	 * @param content
	 *            指定内容
	 * @param fileName
	 *            文件名
	 * @throws IOException
	 */
	public static void writeFile(byte[] content, String fileName)
			throws IOException {
		OutputStream out = new FileOutputStream(new File(fileName));
		out.write(content);
		out.close();
	}

	/**
	 * 读取指定文件
	 * 
	 * @param fileName
	 *            文件
	 * @return 字符串
	 * @throws IOException
	 */
	public static byte[] readFile(String fileName) throws IOException {
		byte content[] = null;
		FileInputStream fis = new FileInputStream(fileName);
		int nLen = fis.available();
		if (nLen > 0) {
			content = new byte[nLen];
			fis.read(content);
		}
		fis.close();
		return content;
	}

	public static void main(String args[]) {
		ZipUtils zu = new ZipUtils();
		// ------------------test1------------------------------------
		String filenames[] = new String[2];
		filenames[0] = "1.txt";
		filenames[1] = "2.txt";
		// filenames[2] = "e:/3.txt";
		try {
			// zu.setZipFile("e:/123.zip");
			java.io.ByteArrayInputStream[] bis = new java.io.ByteArrayInputStream[2];
			bis[0] = new java.io.ByteArrayInputStream("this is a test."
					.getBytes());
			bis[1] = new java.io.ByteArrayInputStream("this is another test."
					.getBytes());
			java.io.ByteArrayOutputStream bo = new java.io.ByteArrayOutputStream();
			zu.setZipOutputStream(bo);
			// zu.zipMultiFiles(filenames);
			zu.zipMultiInputStream(bis, filenames);
			FileOutputStream fo = new FileOutputStream("e:/123.zip");
			fo.write(bo.toByteArray());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void extZipFileList(String zipFileName, String extPlace)
			throws IOException {
		ZipInputStream in = new ZipInputStream(new FileInputStream(zipFileName));

		ZipEntry entry = null;

		while ((entry = in.getNextEntry()) != null) {

			String entryName = entry.getName();

			if (entry.isDirectory()) {
				File file = new File(extPlace + entryName);
				file.mkdirs();
			} else {

				FileOutputStream os = new FileOutputStream(extPlace + entryName);

				byte[] buf = new byte[1024];

				int len;
				while ((len = in.read(buf)) > 0) {
					os.write(buf, 0, len);
				}
				os.close();
				in.closeEntry();
			}
		}
	}

	public static boolean existFile(String zipFileName, String fileName)
			throws IOException {
		ZipInputStream in = new ZipInputStream(new FileInputStream(zipFileName));

		ZipEntry entry = null;

		while ((entry = in.getNextEntry()) != null) {

			String entryName = entry.getName();

			if (!entry.isDirectory() && entryName.equals(fileName)) {
				return true;
			}
		}
		return false;
	}
}