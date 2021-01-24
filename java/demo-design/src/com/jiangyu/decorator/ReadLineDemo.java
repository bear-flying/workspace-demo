package com.jiangyu.decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author JiangYu
 * 
 * 装饰者设计模式  实现
 * 
 * 需求：
 * 1,编写一个类拓展BufferedReader的功能，增强readLine()方法返回的字符串带有行号。
 * 2,编写一个类拓展BufferedReader的功能，增强readLine()方法返回的字符串带有分号。
 * 3,编写一个类拓展BufferedReader的功能，增强readLine()方法返回的字符串带有行号 + 分号。
 */

//带行号的缓冲输入字符流
class BufferedLineNum extends BufferedReader{

	//在内部维护一个被装饰类的引用
	BufferedReader bufferedReader;
	
	int count = 1;
	
	public BufferedLineNum(BufferedReader bufferedReader) {
		super(bufferedReader);
		this.bufferedReader = bufferedReader;
	}
	
	public String readLine() throws IOException{
		String line = bufferedReader.readLine();
		if(line == null) return null;
		line = count + " " + line;
		count++;
		return line;
	}
}

//带分号的缓冲输入字符流
class BufferedSemi extends BufferedReader{

	//在内部维护一个被装饰类的引用
	BufferedReader bufferedReader;
	
	public BufferedSemi(BufferedReader bufferedReader) {
		super(bufferedReader);
		this.bufferedReader = bufferedReader;
	}
	
	public String readLine() throws IOException{
		String line = bufferedReader.readLine();
		if(line == null) return null;
		line = line + ";";
		return line;
	}
}

public class ReadLineDemo {
	
	public static void main(String[] args) throws IOException {
		File file = new File("F:\\Demo.java");
		//建立数据的输入通道
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		//建立带行号的缓冲输入字符流
		BufferedLineNum bufferedLineNum = new BufferedLineNum(bufferedReader);
		//建立带行号+分号的缓冲输入字符流
		BufferedSemi bufferedSemi = new BufferedSemi(bufferedLineNum);
		
		String line = null;
		while ((line = bufferedSemi.readLine()) != null) {
			System.out.println(line);
		}
		bufferedSemi.close();
		bufferedLineNum.close();
		bufferedReader.close();
	}
}
