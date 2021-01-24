package com.founder.util;

import java.util.UUID;

public class UUIDGenerator {
	
	public static String generate(){
		
		String uuid = UUID.randomUUID().toString(); 
		return uuid;
		
	}
	
	public static String generate(boolean normal){
		
		String uuid = generate();
		if(normal){
			return uuid.replaceAll("-", "");
		}else{
			return uuid;
		}
		
	}

}
