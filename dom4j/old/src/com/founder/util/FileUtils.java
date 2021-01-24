package com.founder.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtils extends org.apache.commons.io.FileUtils{
	
	private static Log log = LogFactory.getLog(FileUtils.class);
	
	/**
	 * 封装文件拷贝操作
	 * 
	 * @param sourceFile
	 *            源文件路径
	 * @param targetFile
	 *            目标文件路径
	 */
	public static void copyFile(String srcFile, String destFile) throws IOException {
		try{
			FileUtils.copyFile(new File(srcFile), new File(destFile));
		}catch(IOException e){
			log.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * 拷贝指定目录下的所有文件到目标目录,可以递归地拷贝子目录
	 * 
	 * @param src
	 *            源目录
	 * @param dest
	 *            目标目录
	 */
	public static void copyDirectory(String srcFile, String destFile) throws IOException {
		try{
			copyDirectory(new File(srcFile), new File(destFile));
		}catch(IOException e){
			log.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * 使用nio进行快速的文件拷贝
	 * 
	 * @param in
	 *            输入文件
	 * @param out
	 *            输出文件
	 * @throws IOException
	 *             当源文件不存在的时候会抛出
	 */
	public static void copyLargeFile(File in, File out) throws IOException {
		if (!in.exists()) {
			throw new FileNotFoundException("源文件不存在");
		}
		if (!out.exists()) {
			out.createNewFile();
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel fcin = null;
		FileChannel fcout = null;
		try {
			fis = new FileInputStream(in);
			fos = new FileOutputStream(out);
			fcin = fis.getChannel();
			fcout = fos.getChannel();
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
			while (true) {
				buffer.clear();
				int r = fcin.read(buffer);
				if (r == -1) {
					break;
				}
				buffer.flip();
				fcout.write(buffer);
			}
		} catch (Exception ex) {
			throw new IOException("拷贝文件出现异常：" + ex.getMessage());
		} finally {
			try {
				fcin.close();
			} catch (Exception ex) {
			}
			try {
				fcout.close();
			} catch (Exception ex) {
			}
			try {
				fis.close();
			} catch (Exception ex) {
			}
			try {
				fos.close();
			} catch (Exception ex) {
			}
		}
	}

	/**
	 * 读取文本文件到字符串
	 * 
	 * @param fileName
	 *            要读取的文本文件的路径
	 * @return 文本文件实际内容的字符串
	 */
	public static String readFile(String fileName) {
		StringBuffer sb = new StringBuffer();
		Vector<String> v = readFileByLine(fileName);
		boolean isDataInVector = (v.size() > 0);

		if (isDataInVector) {
			for (int i = 0; i < v.size(); i++) {
				sb.append(v.elementAt(i));
				sb.append("\n");
			}
			return sb.toString();
		} else {
			return null;
		}
	}

	/**
	 * 逐行读取文本文件
	 * 
	 * @param fileName
	 *            要读取的文本文件的路径
	 * @return Vector结构的字符串数组
	 */
	private static Vector<String> readFileByLine(String fileName) {
		String s;
		Vector<String> v = new Vector<String>();
		FileReader fr = null;
		LineNumberReader lnr = null;

		try {
			fr = new FileReader(fileName);
			lnr = new LineNumberReader(fr);

			while ((s = lnr.readLine()) != null) {
				v.addElement(s);
			}
		} catch (Exception e) {
			log.error("",e);
		} finally {
			try {
				fr.close();
			} catch (Exception ex) {
			}
			try {
				lnr.close();
			} catch (Exception ex) {
			}
		}
		return v;
	}

	/**
	 * 写字符串到指定文件中,如果文件已经存在则直接覆盖
	 * 
	 * @param fileName
	 *            要写入文件的文件名
	 * @param src
	 *            要写入的字符串内容
	 */
	public static boolean writeStringToFile(String fileName, String src) {
		if (src == null) {
			src = "";

		}
		boolean isOk = true;
		FileWriter out = null;
		try {
			out = new FileWriter(fileName);
			out.write(src);
			out.close();
		} catch (IOException e) {
			isOk = false;
			e.printStackTrace();
		} catch (Exception e) {
			isOk = false;
			e.printStackTrace();
		} finally {
			out = null;
		}
		return isOk;
	}

	/**
	 * 创建目录
	 * 
	 * @param path
	 *            路径
	 */
	public static void makeDirs(String path) {
		File file = new File(path);
		try {
			file.mkdirs();
		} catch (Exception e) {
		} finally {
			file = null;
		}
	}

	/**
	 * 将指定的文件进行压缩 只针对一个文件将其压缩到同级目录中 如：/usr/local/test.txt -->
	 * /usr/local/test.zip
	 * 
	 * @param filePath
	 *            文件名
	 * @return 操作成功--true/否则--false
	 */
	public static boolean zipFile(String filePath) {
		File file = new File(filePath);
		// 检查是否是文件
		if (!file.isFile()) {
			return false;
		}

		// 取文件名
		String fileName = file.getName();
		// String separator = File.separator;

		// 替换文件名
		String destFileName = null;
		String destFilePath = null;
		int position = fileName.lastIndexOf(".");
		if (position > 0) {
			destFileName = fileName.substring(0, position) + ".zip";
		} else {
			destFileName = fileName + ".zip";
		}
		destFilePath = StringUtils.replace(filePath, fileName, destFileName);

		// 中间变量
		boolean isOk = true;
		int buffer = 1024;
		FileInputStream in = null;
		BufferedInputStream origin = null;
		FileOutputStream dest = null;
		ZipOutputStream out = null;
		byte data[] = new byte[buffer];
		ZipEntry entry = null;
		int count;

		// 实际操作
		try {
			dest = new FileOutputStream(destFilePath);
			out = new ZipOutputStream(new BufferedOutputStream(dest));
			in = new FileInputStream(file);
			origin = new BufferedInputStream(in, buffer);
			entry = new ZipEntry(fileName);
			out.putNextEntry(entry);
			while ((count = origin.read(data, 0, buffer)) != -1) {
				out.write(data, 0, count);
			}
			origin.close();
			in.close();
			out.close();
			dest.close();
		} catch (Exception e) {
			e.printStackTrace();
			isOk = false;
		} finally {
			origin = null;
			in = null;
			out = null;
			dest = null;
		}
		return isOk;
	}

	/**
	 * 删除文件
	 * 
	 * @param file
	 *            文件名
	 * @return 操作成功--true/否则--false
	 */
	public static boolean deleteFile(File file) {
		boolean isOk = false;
		if (file.isFile()) {
			try {
				isOk = file.delete();
			} catch (Exception e) {
				isOk = false;
			}
		}
		return isOk;
	}

	/**
	 * 写对象数据到指定的文件
	 * 
	 * @param obj
	 *            对象实例
	 * @param path
	 *            文件路径
	 */
	public static void writeObjectToFile(Object obj, String path) {
		writeObjectToFile(obj, new File(path));
	}

	/**
	 * 写对象数据到指定的文件
	 * 
	 * @param obj
	 *            对象实例
	 * @param path
	 *            文件对象
	 */
	public static void writeObjectToFile(Object obj, File path) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(path);
			writeObjectToFile(obj, out);
		} catch (Exception ex) {
			log.error("",ex);
		} finally {
			try {
				out.close();
			} catch (Exception ex) {
				log.error("",ex);
			}
		}
	}

	/**
	 * 写对象数据到指定的输出流
	 * 
	 * @param obj
	 *            对象实例
	 * @param out
	 *            输出流
	 */
	public static void writeObjectToFile(Object obj, OutputStream out) {
		ObjectOutputStream objOut = null;
		try {
			objOut = new ObjectOutputStream(out);
			objOut.writeObject(obj);
		} catch (Exception ex) {
			log.error("",ex);
		} finally {
			try {
				objOut.close();
			} catch (Exception ex) {
				log.error("",ex);
			}
		}
	}

	/**
	 * 从指定文件中读入对象数据
	 * 
	 * @param path
	 *            文件路径
	 * @return Object 读入的对象实例
	 */
	public static Object readObjectFromFile(String path) {
		return readObjectFromFile(new File(path));
	}

	/**
	 * 从指定文件中读入对象数据
	 * 
	 * @param path
	 *            文件路径
	 * @return Object
	 */
	public static Object readObjectFromFile(File path) {
		FileInputStream in = null;
		Object obj = null;
		try {
			in = new FileInputStream(path);
			obj = readObjectFromFile(in);
		} catch (Exception ex) {
		} finally {
			try {
				in.close();
			} catch (Exception ex) {
			}
		}
		return obj;
	}

	/**
	 * 从指定的流中读入对象实例
	 * 
	 * @param in
	 *            对象输入流
	 * @return Object 读入的对象实例
	 */
	public static Object readObjectFromFile(InputStream in) {
		ObjectInputStream objIn = null;
		Object obj = null;
		try {
			objIn = new ObjectInputStream(in);
			obj = objIn.readObject();
		} catch (Exception ex) {
		} finally {
			try {
				objIn.close();
			} catch (Exception ex) {
			}
		}
		return obj;
	}

	/**
	 * 文件同名移动到一个目录或者改名为任意目录下的文件
	 * 
	 * @param input
	 *            要移动的源文件
	 * @param output
	 *            目标文件或目标目录
	 * @return 成功移动为true 否则为false
	 * @throws java.lang.Exception
	 * @author Liu WenMin
	 */
	public static boolean move(String input, String output) throws Exception {
		boolean bl = false;

		/* 判断源文件是否存在 */
		File inputFile = new File(input);
		if (!inputFile.exists()) {
			throw new Exception("源文件不存在!");
		}

		File outputFile = new File(output);

		/* 目标存在 */
		if (outputFile.exists()) {
			/* 如果是目录 将源文件移到这个目录下 */
			if (outputFile.isDirectory()) {
				outputFile = new File(output, inputFile.getName());
			} else {
				/* 如果存在同名的文件 先删除 */
				outputFile.delete();
				// throw new Exception("目标处已经存在同名文件！");

			}
		}

		/* 目标不存在 以上级为目录 最后一个为文件名 改名移动 */
		else {
			File parentFile = outputFile.getParentFile();
			parentFile.mkdirs();
			outputFile = new File(parentFile, outputFile.getName());
		}

		bl = inputFile.renameTo(outputFile);
		return bl;
	}


	/**
	 * @param home
	 * @throws Exception
	 */
	public static void makehome(String home) throws Exception {
		File homedir = new File(home);
		if (!homedir.exists()) {
			try {
				homedir.mkdirs();
			} catch (Exception ex) {
				throw new Exception("Can not mkdir :" + home
						+ " Maybe include special charactor!");
			}
		}
	}

	

	/**
	 * 移到源目录下的所有文件到目标目录下
	 * 
	 * @param src
	 *            源目录
	 * @param dest
	 *            目标目录
	 * @throws IOException
	 */
	public static void moveDirectory(String src, String dest)
			throws IOException {
		moveDirectory(new File(src), new File(dest));
	}

	/**
	 * 移到源目录下的所有文件到目标目录下
	 * 
	 * @param src
	 *            源目录
	 * @param dest
	 *            目标目录
	 * @throws IOException
	 */
	public static void moveDirectory(File src, File dest) throws IOException {
		copyDirectory(src, dest, true);
	}


	/**
	 * del a directory recursively,that means delete all files and directorys.
	 * 
	 * @param directory
	 *            the directory that will be deleted.
	 * @throws Exception
	 */
	public static void recursiveRemoveDir(File directory) throws Exception {
		if (!directory.exists()) {
			throw new IOException(directory.toString() + " do not exist!");
		}

		String[] filelist = directory.list();
		File tmpFile = null;
		for (int i = 0; i < filelist.length; i++) {
			tmpFile = new File(directory.getAbsolutePath(), filelist[i]);
			if (tmpFile.isDirectory()) {
				recursiveRemoveDir(tmpFile);
			} else if (tmpFile.isFile()) {
				try {
					tmpFile.delete();
				} catch (Exception ex) {
					throw new Exception(tmpFile.toString()
							+ " can not be deleted " + ex.getMessage());
				}
			}
		}
		try {
			directory.delete();
		} catch (Exception ex) {
			throw new Exception(directory.toString() + " can not be deleted "
					+ ex.getMessage());
		} finally {
			filelist = null;
		}
	}

	/**
	 * Returns a reference to a file with the specified name that is located
	 * somewhere on the classpath. The code for this method is an adaptation of
	 * code supplied by Dave Postill.
	 * 
	 * @param name
	 *            the filename.
	 * 
	 * @return a reference to a file or <code>null</code> if no file could be
	 *         found.
	 */
	public static File findFileOnClassPath(String name) {

		String classpath = System.getProperty("java.class.path");
		String pathSeparator = System.getProperty("path.separator");
		String fileSeparator = System.getProperty("file.separator");

		StringTokenizer tokenizer = new StringTokenizer(classpath,
				pathSeparator);

		while (tokenizer.hasMoreTokens()) {
			String pathElement = tokenizer.nextToken();

			File directoryOrJar = new File(pathElement);
			File absoluteDirectoryOrJar = directoryOrJar.getAbsoluteFile();

			if (absoluteDirectoryOrJar.isFile()) {
				File target = new File(absoluteDirectoryOrJar.getParent()
						+ fileSeparator + name);
				if (target.exists()) {
					return target;
				}
			} else {
				File target = new File(pathElement + fileSeparator + name);
				if (target.exists()) {
					return target;
				}
			}

		}
		return null;

	}

	public static boolean fileExists(String _sPathFileName) {
		File file = new File(_sPathFileName);
		return file.exists();
	}

	public static boolean pathExists(String _sPathFileName) {
		String sPath = extractFilePath(_sPathFileName);
		return fileExists(sPath);
	}

	public static String extractFileName(String _sFilePathName) {
		int nPos = _sFilePathName.lastIndexOf(File.separatorChar);
		return _sFilePathName.substring(nPos + 1);
	}

	public static String extractHttpFileName(String _sFilePathName) {
		int nPos = _sFilePathName.lastIndexOf("/");
		return _sFilePathName.substring(nPos + 1);
	}

	public static String extractFileExt(String _sFilePathName) {
		int nPos = _sFilePathName.lastIndexOf('.');
		return nPos < 0 ? "" : _sFilePathName.substring(nPos + 1);
	}

	public static String extractFilePath(String _sFilePathName) {
		int nPos = _sFilePathName.lastIndexOf(File.separatorChar);
		return nPos < 0 ? "" : _sFilePathName.substring(0, nPos + 1);
	}

	public static String toAbsolutePathName(String _sFilePathName) {
		File file = new File(_sFilePathName);
		return file.getAbsolutePath();
	}

	public static String extractFileDrive(String _sFilePathName) {
		int nLen = _sFilePathName.length();
		if (nLen > 2 && _sFilePathName.charAt(1) == ':')
			return _sFilePathName.substring(0, 2);
		if (nLen > 2 && _sFilePathName.charAt(0) == File.separatorChar
				&& _sFilePathName.charAt(1) == File.separatorChar) {
			int nPos = _sFilePathName.indexOf(File.separatorChar, 2);
			if (nPos >= 0)
				nPos = _sFilePathName.indexOf(File.separatorChar, nPos + 1);
			return nPos < 0 ? _sFilePathName : _sFilePathName
					.substring(0, nPos);
		} else {
			return "";
		}
	}
}
