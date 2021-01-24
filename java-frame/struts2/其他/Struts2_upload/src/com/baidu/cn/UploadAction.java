package com.baidu.cn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private File file;//文件对应的 File 对象
	private String fileContentType;//文件类型
	private String fileFileName;//文件名
	
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

	@Override
	public String execute() throws Exception {
		System.out.println(file);
		System.out.println(fileContentType);
		System.out.println(fileFileName);

		ServletContext servletContext = ServletActionContext
				.getServletContext();
		String path = servletContext.getRealPath("/upload/" + fileFileName);
		System.out.println(path);
		File destFile=new File(path+"/"+this.fileFileName);
		FileUtils.copyFile(file, destFile);
		
//		FileOutputStream out = new FileOutputStream(path);
//		FileInputStream in = new FileInputStream(file);
//
//		byte[] buffer = new byte[1024];
//		int len = 0;
//
//		while ((len = in.read(buffer)) != -1) {
//			out.write(buffer, 0, len);
//		}
//
//		out.close();
//		in.close();

		return SUCCESS;
	}

}
