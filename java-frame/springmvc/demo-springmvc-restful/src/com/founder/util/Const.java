package com.founder.util;

public class Const {
	
	public static final int NOT_EXISTS = -1;
	
	public static final String CREATEDATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static byte[] JPG = {0x4a, 0x46, 0x49, 0x46};
	
	public static byte[] GIF = {0x47, 0x49, 0x46};
	
	public static byte[] PNG = {(byte)0x89, 0x50, 0x4e, 0x47, 0x0d, 0x0a, 0x1a, 0x0a};
	
	public static final String IMG_JPG = "JPG";
	
	public static final String IMG_GIF = "GIF";
	
	public static final String IMG_PNG = "PNG";
	
	/**未发布*/
	public static final int STATUS_PUB_NOT = 0;
	/**已发布*/
	public static final int STATUS_PUB_DONE = 1;
	/**定时发布*/
	public static final int STATUS_PUB_TIMED = 2;
	/**发布中*/
	public static final int STATUS_PUB_ING = 3;
	/**审批中*/
	public static final int STATUS_AUDITING = 4;
	/**已驳回*/
	public static final int STATUS_REJECTED = 5;
	/**等待抽图*/
	public static final int STATUS_EXTRACTING = 6;
	
	
}
