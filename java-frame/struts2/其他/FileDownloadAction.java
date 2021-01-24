package com.rain.sponsor.file;

import java.io.File;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// 告诉浏览器是以下载的形式接收
	private static String contentType = "application/x-msdownload";
	// 告诉浏览器数据将要的文件和文件名
	private static String contentDisposition = "attachment;filename=";
	// 设置服务器读取文件的缓冲区大小
	private static String BUFFER_SIZE = "2048";

	// 前台传过来得需要下载的文件名、路径
	private String fnamePath;
	
	public String downLoad(){
		File file = new File(this.fnamePath);
		
		this.contentDisposition+=file.getName();
		
		return "fileDown";
	}
	
	public InputStream getFiles(){
		return ServletActionContext.getServletContext().getResourceAsStream("/file/"+this.fnamePath);
	}

	public String getFnamePath() {
		return fnamePath;
	}

	public void setFnamePath(String fnamePath) {
		this.fnamePath = fnamePath;
	}

}
