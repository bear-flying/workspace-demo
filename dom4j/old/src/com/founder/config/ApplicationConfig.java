package com.founder.config;

import java.io.File;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 从配置文件中读取所需的元素值
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: 北大方正电子有限公司数字媒体事业部 翔宇组</p>
 *
 * @author yyang
 * @version 1.0
 */
public class ApplicationConfig {
	
	 private static Log log = LogFactory.getLog(ApplicationConfig.class);
	 private static ApplicationConfig applicationconfig = null;
	 private static XMLConfiguration xml_config = null;
	 private static final String CONFIG_ENCODING = "UTF-8";
	 private static final File CONFIG_HOME = new File(System.getProperty("user.dir") + File.separatorChar + "conf");
	 
	 private ApplicationConfig() throws ConfigurationException{
		 loadConfig();
	 }
	 
	 public static ApplicationConfig getInstance(){
		 if(applicationconfig==null){
			 try{
				 applicationconfig = new ApplicationConfig();
			 }catch(ConfigurationException e){
				 log.error(e.getMessage());
			 }
		 }
		 return applicationconfig;
	 }
	 
	 private synchronized void loadConfig() throws ConfigurationException{
		 try{
			 xml_config = new XMLConfiguration(CONFIG_HOME.getAbsolutePath()+File.separatorChar + "config.xml");
			 xml_config.setEncoding(CONFIG_ENCODING);
		 }catch(ConfigurationException e){
			 log.fatal("加载配置文件出错:",e);
			 throw e;
		 }
	 }

	 
	 public String getAppHome(){
		 return System.getProperty("user.dir");
	 }
	 
	 public String getConfHome(){
		 return CONFIG_HOME.getPath();
	 }
	 
	 public String getString(String key){
		 return getString(key,null);
	 }
	 
	 public String getString(String key,String defaultValue){
		 return xml_config.getString(key, defaultValue);
	 }
	 
	 public int getInt(String key){
		 return getInt(key,0);
	 }
	 
	 public long getLong(String key,long defaultValue){
		 return xml_config.getLong(key, defaultValue);
	 }
	 
	 public long getLong(String key){
		 return getLong(key,0);
	 }
	 
	 public int getInt(String key,int defaultValue){
		 return xml_config.getInt(key, defaultValue);
	 }
	 
	 public boolean getBoolean(String key){
		 return getBoolean(key,false);
	 }
	 
	 public boolean getBoolean(String key, boolean defaultValue){
		 String value = xml_config.getString(key,"false");
		 if(value.equalsIgnoreCase("true")
				 || value.equalsIgnoreCase("1")
				 || value.equalsIgnoreCase("y")
				 || value.equalsIgnoreCase("yes")
				 || value.equalsIgnoreCase("on")){
			 return true;
		 }else if(value.equalsIgnoreCase("false")
				 || value.equalsIgnoreCase("0")
				 || value.equalsIgnoreCase("n")
				 || value.equalsIgnoreCase("no")
				 || value.equalsIgnoreCase("off")){
			 return false;
		 }else{
			 return defaultValue;
		 }
	 }

	 
}
