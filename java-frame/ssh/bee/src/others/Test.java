package others;

import java.lang.reflect.Field;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Test {

	static public void main(String[] args){
		
		try {
			HttpServletRequest request = null;
			//正常是这样取：request.getParameter("username")/password…�?;
			//解析（动态加载）ParameterAction这个�?
			Class clazz = Class.forName("com.javasky.stock.action.ParameterAction");
			Object obj = null;
			try {
				obj = clazz.newInstance();//创建ParameterAction类的实例 类型为Object
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			//拿到ParameterAction类中 �?��的域成员
			Field[] fs = clazz.getDeclaredFields();
			//迭代域成�?
			for(Field f : fs){
				//获取表单�?�?��的参数名�? 拿出�?��的参数名与action中的�?��域成员做对比
				Enumeration enum_ = request.getParameterNames();
				boolean isAccess = f.isAccessible();
				if(isAccess){
					f.setAccessible(true);
				}
				while(enum_.hasMoreElements()){
					//取出下一个元素Object 转成String 赋�?给username
					String paramsname = enum_.nextElement().toString();
					//f.getName()可以获取 迭代中的 当前域成员的名字  
					if(paramsname.equals(f.getName())){
						//如果双方�?�� 就获�?
						Object value = request.getParameter(paramsname);
						try {
							f.set(obj, value);//为属性赋�?
							//实际�?为属性赋�?应该�?
							//利用反射机制获取当前属�?的set方法 调用set方法 获取method 用invoke 把value传进�?
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
				f.setAccessible(isAccess);
				//输出域成员的名字
				System.out.println("fname----"+f.getName());
				
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
