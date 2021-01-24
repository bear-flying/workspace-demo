package com.baidu.cn;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownLoadAction extends ActionSupport {
	// contentType: 结果类型
	// contentLength: 下载的文件的长度
	// contentDisposition: 设定 Content-Dispositoin 响应头. 
	// 该响应头指定接应是一个文件下载类型, 一般取值为 attachment;
	// filename="document.pdf".
	// inputName: 指定文件输入流的 getter 定义的那个属性的名字. 默认为 inputStream
	// bufferSize: 缓存的大小. 默认为 1024
	// allowCaching: 是否允许使用缓存
	// contentCharSet: 指定下载的字符集
	private String contentType;
	private long contentLength;
	private String contentDisposition;
	private InputStream inputStream;

	public String getContentType() {
		return contentType;
	}

	public long getContentLength() {
		return contentLength;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	@Override
	public String execute() throws Exception {

		// 确定各个成员变量的值
		contentType = "text/html";
		contentDisposition = "attachment;filename=hidden.html";
		// servletContext接口是Servlet中最大的一个接口，呈现了web应用的Servlet视图。
		// ServletContext实例是通过 getServletContext()方法获得的，
		// 由于HttpServlet继承Servlet的关系，GenericServlet类和HttpServlet类同时具有该方法。
		ServletContext servletContext = ServletActionContext
				.getServletContext();
		String fileName = servletContext.getRealPath("/files/hidden.html");
		inputStream = new FileInputStream(fileName);
		contentLength = inputStream.available();

		return SUCCESS;
	}
}
