package cn.itcast.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//在servlet用getOutputStream输出中文问题
public class ResponseDemo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		test2(response);
	}

	private void test2(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException {
		String data="中国2 ";
		//html: <meta>标签模拟一个http响应头
		OutputStream out=response.getOutputStream();
		//out.write(data.getBytes());
		out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
		out.write(data.getBytes("UTF-8"));
	}
	private void test1(HttpServletResponse response) throws IOException,
	UnsupportedEncodingException {
		String data="中国 ";
		//程序以什么码表输出，一定要控制浏览器以什么码表打开
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		OutputStream out=response.getOutputStream();
		//out.write(data.getBytes());
		out.write(data.getBytes("UTF-8"));
	}

}
