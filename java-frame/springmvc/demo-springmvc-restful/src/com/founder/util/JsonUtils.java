package com.founder.util;

import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	private static final Log log = LogFactory.getLog(JsonUtils.class);  
    private static final ObjectMapper mapper = new ObjectMapper();  
    public static String jsonFromObject(Object object) {  
        StringWriter writer = new StringWriter();  
        try {  
            mapper.writeValue(writer, object);  
        } catch (RuntimeException e) {  
            throw e;  
        } catch (Exception e) {  
            log.error("Unable to serialize to json: " + object, e);  
            return null;  
        }  
        return writer.toString();  
    }  
  
 
  
}
