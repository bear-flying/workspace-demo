package com.founder.datamover.util.jpublish.template;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.founder.datamover.util.jpublish.util.DumpStringStream;

public class ComponentHelper {

	public static String BODYTAG = "<body xmlns=\"http://www.w3.org/1999/xhtml\">";
	
	public static boolean isXML(String sContent){
		boolean bResult = false;
		DocumentBuilder parser;

		DocumentBuilderFactory factory = null;
		@SuppressWarnings("unused")
		org.w3c.dom.Document ndoc = null;
		DumpStringStream ds = null;
		String sHead = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+BODYTAG;
		String sTail = "</body>";
		try{
			factory = (DocumentBuilderFactory)Class.forName("org.apache.xerces.jaxp.DocumentBuilderFactoryImpl").newInstance();
			sContent = filterXml(sContent);
			if(sContent.indexOf("<?xml")>=0){
				ds = new DumpStringStream(sContent.trim(), "UTF-8");
			}else{
				ds = new DumpStringStream(sHead+sContent.trim()+sTail, "UTF-8");
			}
			parser = factory.newDocumentBuilder();
			ndoc = parser.parse(ds);
			bResult = true;
       }catch(Exception ex){
       }finally{
           ndoc = null;
           parser = null;
           factory = null;
           ds = null;
       }
       return bResult;
	}

	
	private static String filterXml(String xml){
		char t1 = 0x8;
		char t2 = 0x5;
		char t3 = 0x4;
		char t4 = 0x3;
		char t5 = 0x7;
		char t6 = 0x1;
		char t7 = 0x2;
		char t8 = 0x6;
		char t9 = 0x9;
		xml = xml.replace(t1,' ');
		xml = xml.replace(t2,' ');
		xml = xml.replace(t3,' ');
		xml = xml.replace(t4,' ');
		xml = xml.replace(t5,' ');
		xml = xml.replace(t6,' ');
		xml = xml.replace(t7,' ');
		xml = xml.replace(t8,' ');
		xml = xml.replace(t9,' ');

		xml = xml.replaceAll("&amp;","&");
		xml = xml.replaceAll("&lt;","<");
		xml = xml.replaceAll("&gt;",">");
		xml = xml.replaceAll("&quot;","\"\"");
		return xml;
	}
  
}

