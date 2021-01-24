package com.bee.utils;



import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileUpload {

	public static String upload(String filename,File myfile)throws Exception{
		//得到文件上传的服务器路径
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getSession().getServletContext().getRealPath("")+"\\upload\\";
		
		//解决文件同名问题
		filename = UUID.randomUUID().toString().replace("-", "")+filename.substring(filename.lastIndexOf("."));
		//System.out.println("fffffffffffff="+filename);
		
		//定义服务器的新文件
		File newFile = new File(path+filename);
		
		//真正上传
		FileUtils.copyFile(myfile, newFile);
		return filename;
	}
}
