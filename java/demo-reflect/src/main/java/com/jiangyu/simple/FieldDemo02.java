package com.jiangyu.simple;

import java.lang.reflect.Field;

/**
 * 
 * @author JiangYu
 * 
 * 将任意一个对象中的所有String类型的成员变量所对应的字符串内容中的“b”改为“a”
 *
 */
public class FieldDemo02 {

	private static void changeStringValue(Object obj) throws Exception {
		Field[] fields = obj.getClass().getFields();
		for(Field field : fields){
			//if(field.getType().equals(String.class)){//这里可以用equals，但表达的意思不正确，用等号一看就是比较内存地址
			//String类型的字节码在内存中只有一份。面试的时候这里加注释，让面试官知道。
			if(field.getType() == String.class){
				String oldValue = (String)field.get(obj);
				String newValue = oldValue.replace('b', 'a');
				field.set(obj, newValue);
			}
		}
		
	}
	
}
