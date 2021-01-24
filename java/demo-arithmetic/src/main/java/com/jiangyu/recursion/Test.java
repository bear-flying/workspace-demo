package com.jiangyu.recursion;


import java.io.File;

/**
 * 遍历一个包含多个子文件的文件，并打印出所有文件的名字
 * 
 * 递归：运行过程自己调用自己
 *
 */
public class Test {
	
	public static void main(String[] args) {
		
		File file = new File("D:\\my");
		
		listFiles(file);
		
		
	}

	/**
	 * 这个方法，做遍历文件夹
	 * @param file
	 */
	private static void listFiles(File file) {
		//是文件
		if(file.isFile()){
			System.out.println(file.getName());
		}else if(file.isDirectory()){
			System.out.println(file.getName());	
//			
//		}else{
			//文件夹
			//通过调研listFiles得到所有子目录
			File[] listFiles = file.listFiles();
			//遍历数组
			for(int i=0;i<listFiles.length;i++){
				
				File file2 = listFiles[i];
				//调用自己——递归
				
				listFiles(file2);
				
				
			}	
		}

	}

}