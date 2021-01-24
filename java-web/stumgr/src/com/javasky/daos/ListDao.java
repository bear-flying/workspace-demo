package com.javasky.daos;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javasky.datas.DataSource;
import com.javasky.datas.IDataSource;
//该DAO用于查询 利用反射机制 这一个DAO可以解决学生、成绩……各种类型的查询
public class ListDao<T> {

	public List<T> getList(Class c,String sql){
		List<T> list = new ArrayList<T>();
		IDataSource ds = DataSource.getInstance();
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			//使用反射机制获得 域成员
			Field[] fields = c.getDeclaredFields();
			while(rs.next()){
				//根据Class c 创建对象
				T o = (T)c.newInstance();//变量类型参数化 不用Object 直接用泛型
				/*传统的写法：
				 * Student s = new Student();
				 * s.setSno(rs.getInt("sno"));
				 * s.setSname(rs.getString("sname"));
				 * */
				for(Field field : fields){
					String fieldName = field.getName();//获取与成员（属性）名
					/*使用反射机制获得set方法名*/
					String methodName ="set"+fieldName.substring(0, 1).toUpperCase()
							+fieldName.substring(1);//获取set方法名
					//获取set方法，域成员是什么类型，返回值就是什么类型
					Method method =c.getMethod(methodName, field.getType());
					//获得返回类型
					String type = field.getType().getSimpleName();
					if("int".equals(type)||"Integer".equals(type)){
						//在这个对象o上执行这个set方法，把获取到的结果集set进去
						method.invoke(o, rs.getInt(fieldName));
					}else if("String".equals(type)){
						method.invoke(o, rs.getString(fieldName));
					}else if("double".equals(type)||"Double".equals(type)){
						method.invoke(o, rs.getString(fieldName));
					}else if("char".equals(type)||"Character".equals(type)){
						method.invoke(o, rs.getString(fieldName));
					}else if("boolean".equals(type)||"Boolean".equals(type)){
						method.invoke(o, rs.getString(fieldName));
					}
				}
				/*把对象装入到集合中*/
				list.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
