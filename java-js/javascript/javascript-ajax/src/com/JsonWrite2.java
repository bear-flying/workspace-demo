package com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonWrite2 {
	public static void main(String[] args) throws Exception {
		JSONArray ja=new JSONArray();
		JSONObject jo1=new JSONObject();
		Student stu=new Student("����",18);
		jo1.put("name", stu.getName());
		jo1.put("age", stu.getAge());
		JSONObject jo2=new JSONObject();
		Student stu2=new Student("����",22);
		jo2.put("name", stu2.getName());
		jo2.put("age", stu2.getAge());
		ja.put(jo1);
		ja.put(jo2);
		FileWriter fw=new FileWriter(new File("c:\\data2.json"));
		fw.write(ja+"");
		fw.flush();
		System.out.println(ja);
		fw.close();
	}
}
