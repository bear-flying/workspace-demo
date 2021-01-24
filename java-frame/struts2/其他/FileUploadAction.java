package com.rain.sponsor.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private final static int BUFFER_SIZE = 16 * 1024;

	private File file;
	private String fileContentType;
	private String fileFileName;
	
	public String upload(){
		String filePath = ServletActionContext.getServletContext().getRealPath("file");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		File uploadFile = new File(filePath+"/"+"ss.txt");
		uploadFile = new File(filePath+"/"+sdf.format(new Date())+".txt");
		//开始上传
		InputStream is = null;
		OutputStream os = null;
		try{
			is = new BufferedInputStream(new FileInputStream(file),BUFFER_SIZE);
			os = new BufferedOutputStream(new FileOutputStream(uploadFile),BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			while(is.read(buffer)>0){
				os.write(buffer);
			}
			is.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

}
