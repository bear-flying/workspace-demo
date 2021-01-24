package com.founder.util;

import java.io.Closeable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StreamCloserUtil {
	
	public static Log logger = LogFactory.getLog(StreamCloserUtil.class);
	
	public static void close(Closeable stream){
		
		try{
			if(stream != null){
				stream.close();
			}
		}catch(Exception exp){
			logger.error("�ر��������������");
		}
		
	}
	
	public static void close(Closeable... streams){
		
		for(int t=0; t<streams.length; ++t){
			close(streams[t]);
		}
		
	}

}
