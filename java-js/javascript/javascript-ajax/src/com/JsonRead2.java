package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonRead2 {
	public static void main(String[] args) throws Exception {
	     FileReader fr = new FileReader(new File("c:\\data2.json"));
	     BufferedReader br=new BufferedReader(fr);
	     String ss=br.readLine();
	     System.out.println(ss);
	     JSONArray ja=new JSONArray(ss);
	     for(int i=0;i<ja.length();i++){
	    	JSONObject jo=ja.getJSONObject(i);
	    	System.out.println(jo.getString("name")+","+jo.getInt("age"));
	     }
	}
}
