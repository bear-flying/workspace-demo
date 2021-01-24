package com;

import java.io.File;
import java.io.FileWriter;
import org.json.JSONObject;

public class JsonWrite {
	public static void main(String[] args) throws Exception {
		JSONObject jo1=new JSONObject();
		Student stu=new Student("张三",18);
		jo1.put("name", stu.getName());
		jo1.put("age", stu.getAge());
		FileWriter fw=new FileWriter(new File("c:\\data.json"));
		fw.write(jo1+"");
		fw.flush();
		System.out.println(jo1);
		fw.close();
	}
}
