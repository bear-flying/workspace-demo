package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;

public class JsonRead {
public static void main(String[] args) throws Exception {
     FileReader fr = new FileReader(new File("c:\\data.json"));
     BufferedReader br=new BufferedReader(fr);
     String ss=br.readLine();
     System.out.println(ss);
     JSONObject jo=new JSONObject(ss);//创建JSONObject对象
     System.out.println(jo.getString("name")+","+jo.getInt("age"));
}
}
