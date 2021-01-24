package com.baidu.parse.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 转换（读取）猫的日志
 */
public class ParserTomcatLog {


	public static void main(String[] args) {
		
		try {
			FileReader fileReader = new FileReader("D:\\Program Files\\GongZuo2\\apache-tomcat-7.0.54\\logs\\localhost_access_log.2016-01-06.txt");
			//每一条日志都是一行一行的显示。故一行一行的读取
			BufferedReader reader = new BufferedReader(fileReader);
			String line = "";
			
			//Set set = new HashSet();
			while((line=reader.readLine())!=null){
				System.out.println(line);//输出的是一行一行的记录
				System.out.println(line.split(" ")[0]);
				//set.add(line.split(" ")[0]);
			}
			System.out.println("9999999999999");
			//System.out.println(set);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
