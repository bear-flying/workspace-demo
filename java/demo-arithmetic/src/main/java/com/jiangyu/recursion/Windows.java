package com.jiangyu.recursion;
import java.io.File;


public class Windows {

	/**
	 * 第一题：通过递归算法将C:\WINDOWS目录下的所有文件及文件夹
	 * 名称打印在控制台。
	 */
	public static void main(String[] args) {
		//创建File类的对象 指向C盘的WINDOWS目录
		File file = new File("C:\\Windows");
		//调用自己定义的打印方法
		prints(file);

	}
	//打印C:\WINDOWS目录下所以文件和目录名的方法
	private static void prints(File file) {
			//如果是文件 直接输出文件名
			if(file.isFile()){
				System.out.println("[-]"+file.getName());
			}else{
				//如果不是文件 直接输出目录名
				System.out.println("[d]"+file.getName());
				//调用File类的listFiles()方法 返回一个File类型的数组
				File[] listFiles = file.listFiles();
				if(null!=listFiles){
					//遍历数组中的元素
					for(File file1 : listFiles){
						//方法中调用自己 实现递归
						prints(file1);
					}
				}
			}	
	}

}
