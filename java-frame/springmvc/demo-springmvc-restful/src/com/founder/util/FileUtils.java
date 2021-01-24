package com.founder.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtils {
	
	private static Log logger = LogFactory.getLog(FileUtils.class);
	
	public static void append(String line, File file) throws Exception{
		
		if(!file.exists()){
			file.createNewFile();
		}
		FileOutputStream fout = null;
		try{
			fout = new FileOutputStream(file, true);
			String lineSep = System.getProperty("line.separator", "\r\n");
			IOUtils.write(line + lineSep, fout, "utf-8");
		}finally{
			StreamCloserUtil.close(fout);
		}
		
	}
	
	public static void write(byte[] bytes, String path) throws Exception{
		
		File file = new File(path);
		write(bytes, file);
		
	}
	
	public static void write(String value, File file) throws Exception{
		
		org.apache.commons.io.FileUtils.writeStringToFile(file, value, "utf-8");
		
	}
	
	public static void write(byte[] bytes, File file) throws Exception{
		
		File dir = file.getParentFile();
		if(!dir.exists()){
			dir.mkdirs();
		}
		if(!file.exists()){
			file.createNewFile();
		}
		org.apache.commons.io.FileUtils.writeByteArrayToFile(file, bytes);
		
	}
	
	public static boolean moveFile(String sourceFile, String targetFile, boolean deleteSrcFile){
		
		File filetarget = new File(targetFile);
		File filesource = new File(sourceFile);
		try {
			org.apache.commons.io.FileUtils.copyFile(filesource, filetarget);
			if(filesource.exists()){
				filesource.delete();
			}
			return true;
		} catch (IOException exp) {
			logger.error("�ļ����Ƴ����쳣{src:" + sourceFile + ", dest: " + filetarget + "}", exp);
			return false;
		}
		
	}

	public static boolean moveFile(String sourceFile, String targetFile) {
		
		return moveFile(sourceFile, targetFile, false);
		
	}
	
	public static boolean copyFile(String sourceFile, String targetFile){
		
		File filesource = new File(sourceFile);
		File filetarget = new File(targetFile);
		try {
			if(!filesource.exists()){
				return false;
			}
			org.apache.commons.io.FileUtils.copyFile(filesource, filetarget);
			return true;
		} catch (IOException exp) {
			logger.error("�ļ����Ƴ����쳣{src:" + sourceFile + ", dest: " + filetarget + "}", exp);
			return false;
		}
		
	}
	
	public static String readFile(File file) throws IOException{
		
		if(file==null){
			return null;
		}
		if(!file.exists()){
			return null;
		}
		return org.apache.commons.io.FileUtils.readFileToString(file, "utf-8");
		
	}
	
}
