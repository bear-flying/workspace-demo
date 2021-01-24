package cn.itcast.response;
//通过response的write流输出文字数据，不能输出电影等二进制流
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//在servlet用getOutputStream输出中文问题
public class ResponseDemo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		test1(response);
	}

	private void test2(HttpServletResponse response) throws IOException {
		String data="中国q";
		//该句代码等价于其后面两句
		response.setContentType("text/html;charset=GB2312");
		//response.setCharacterEncoding("GB2312");
		//response.setHeader("Content-type", "text/html;charset=ISO-8859-1");
		PrintWriter out=response.getWriter();
		out.write(data);//
	}
	private void test1(HttpServletResponse response) throws IOException {
		String data="中国q";
		//设置response使用的码表，以控制response以什么码表向浏览器输入数据,默认为ISO-8859-1
		response.setCharacterEncoding("GB2312");
		//指定浏览器以什么码表打开服务器发送的数据
		response.setHeader("Content-type", "text/html;charset=GB2312");
		//response.setHeader("Content-type", "text/html;charset=ISO-8859-1");
		PrintWriter out=response.getWriter();
		out.write(data);//
	}



}
