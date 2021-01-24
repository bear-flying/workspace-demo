package com.doctor.utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;



public class BaseDao extends BaseDaoSupport {

	// 鏌ヨ鍏ㄩ儴鐨勬柟娉�
	public <T> List<T> queryAll(Class<T> clazz, String sql) {
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<Map<String, Object>> result = changeToListMap(rs);
			list = changeToList(clazz, result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, st, rs);
		}

		return list;
	}

	// 鎸夋潯浠舵煡璇竴鏉�
	public <T> T queryOne(Class<T> clazz, String sql, Object... args) {
		T bean = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				st.setObject(i + 1, args[i]);
			}
			rs = st.executeQuery();
			Map<String, Object> result = new HashMap<String, Object>();
			if (rs.next()) {
				for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					String label = rs.getMetaData().getColumnLabel(i + 1);
					Object obj = rs.getObject(i + 1);
					result.put(label, obj);
				}
			}
			if (result.size() > 0) {
				bean = clazz.newInstance();
				for (Map.Entry<String, Object> map : result.entrySet()) {
					String key = map.getKey();
					Object value = map.getValue();

					BeanUtils.setProperty(bean, key, value);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, st, rs);
		}

		return bean;
	}
	//鎸夋潯浠舵煡璇�
	public <T> List<T> findAllByCondition(Class<T> clazz, String sql ,Object...args ) {
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				st.setObject(i + 1, args[i]);
			}
			rs = st.executeQuery();
			List<Map<String, Object>> result = changeToListMap(rs);
			list = changeToList(clazz, result);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	// 澧�鍒�鏀圭殑鏂规硶
	public void executeUpdate(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DBUtils.getConnection();
			//System.out.println(conn);
			st = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				st.setObject(i + 1, args[i]);
			}
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, st, null);
		}

	}

	// MySQL鍒嗛〉鏌ヨ
	public <T> PageBean<T> queryByPage(Class<T> clazz, String sql,
			String count, int page, int pageSize) {
		PageBean<T> pageBean = new PageBean<T>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		List<T> list = getForList(clazz, sql, page, pageSize);
		pageBean.setList(list);
		int totalNums = getTotalNums(count);
		pageBean.setTotalNums(totalNums);
		pageBean.setActualPageSize(list.size());
		pageBean.setTotalPages(totalNums % pageSize == 0 ? totalNums / pageSize
				: totalNums / pageSize + 1);
		return pageBean;
	}

	// 鍒嗛〉鏌ヨ2(鍗曡〃鍒嗛〉+1涓瓧娈电殑妯＄硦鏌ヨ)
	public <T> PageBean<T> queryByPage2(Class<T> clazz,String table,String column, int page, int pageSize,String...args) {
		
		PageBean<T> pageBean = new PageBean<T>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		StringBuffer sb = new StringBuffer();;
		for(int i=0;i<args.length;i++){
			if(args[i] == null){
				args[i]="";
			}
			sb = sb.append(" where 1 = 1 ");
			
			if(args[i]!= null && !args[i].trim().equals("")){
				sb.append(" and "+column+" like '%" + args[i] +"%' ");
			}
		
		}
		String sql = "select * FROM "+ table + " " + sb.toString() + " limit ? , ?";
		String count = "select count(*) from "+ table + " " + sb.toString() ;
		//System.out.println(sql);
		List<T> list = getForList(clazz, sql, page, pageSize);
		//System.out.println(list.toString());
		pageBean.setList(list);
		int totalNums = getTotalNums(count);
		pageBean.setTotalNums(totalNums);
		pageBean.setActualPageSize(list.size());
		pageBean.setTotalPages(totalNums % pageSize == 0 ? totalNums / pageSize
				: totalNums / pageSize + 1);
		return pageBean;
	}

	// 鍒嗛〉鏌ヨ3(鍙岃〃鍒嗛〉+1涓瓧娈电殑妯＄硦鏌ヨ)
	public <T> PageBean<T> queryByPage3(Class<T> clazz,String sql1,String sql2,String column,int page, int pageSize,String...args) {
		
		PageBean<T> pageBean = new PageBean<T>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		StringBuffer sb = new StringBuffer();
		if(args.length>0){	
			sb = sb.append(" where 1 = 1 ");
		}
		for(int i=0;i<args.length;i++){
			if(args[i] == null){
				args[i]="";
			}
			
			if(column!=null){
				if(args[i]!= null && !args[i].trim().equals("")){
					sb.append(" and "+column+" like '%" + args[i] +"%' ");
				}
			}
			
		}

		String sql = sql1 + " " + sb.toString() + " limit ? , ?";
		String count = sql2 + " " + sb.toString() ;
		//System.out.println(sql);
		List<T> list = getForList(clazz, sql, page, pageSize);
		pageBean.setList(list);
		int totalNums = getTotalNums(count);
		pageBean.setTotalNums(totalNums);
		pageBean.setActualPageSize(list.size());
		pageBean.setTotalPages(totalNums % pageSize == 0 ? totalNums / pageSize
				: totalNums / pageSize + 1);
		return pageBean;
	}
	
	
	
	
	
	//分页 （适用所有数据库）只需要传入普通查询的SQL 不需要传入带有分页参数的SQL语句：如limit rownum
		public <T> PageBean<T> queryPage(Class<T> clazz,String sql,int page,int pageSize,Object...args){
			PageBean<T> pageBean = new PageBean<T>();
			Connection conn = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			int index = 0;
			try{
				conn = DBUtils.getConnection();
				//要声明是可分页并且是只读的
				st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				for (int i = 0; i < args.length; i++) {
					st.setObject(i + 1, args[i]);
				}
				rs = st.executeQuery();
				//如果有最后一条，证明结果集中至少有一条数据
				if(rs.last()){
					//总记录数(因为已经挪到最后一条 所以getRow()能得到总条数)
					int totalNums = rs.getRow();
					//总页数
					int totalPages = totalNums/pageSize + ((totalNums%pageSize)==0?0:1);
					if(page>totalPages) return pageBean;
					//计算开始循环号码~第一页：(0-0)*5+1=1~第二页为6 
					int start = (page-1)*pageSize + 1;
					//定位
					rs.absolute(start);
//					while(rs.next()){
//					Map<String,Object> map = new HashMap<String,Object>();
//						for(int i =1;i<rs.getMetaData().getColumnCount()+1;i++){
//								map.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
//						}
//						result.add(map);
//					}
					pageBean.setPage(page);
					pageBean.setPageSize(pageSize);
					pageBean.setTotalPages(totalPages);
					pageBean.setTotalNums(totalNums);
					List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
					do{
						Map<String,Object> map = new HashMap<String,Object>();
						for(int i =1;i<rs.getMetaData().getColumnCount()+1;i++){
								map.put(rs.getMetaData().getColumnLabel(i), rs.getObject(i));
						}
						
						result.add(map);
					}while(rs.next() && ++index<pageSize);
					List<T> list = this.changeToList(clazz, result);
					pageBean.setList(list);
					pageBean.setActualPageSize(list.size());
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBUtils.close(conn, st, rs);
			}
					
			return pageBean;
		}
	

	
	//澧炲垹SQL ---- 浜嬪姟
	public static void executeTran(String...sqlArray){
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			
			conn.setAutoCommit(false);
			
			for (String sql : sqlArray) {
				st = conn.prepareStatement(sql);
				st.executeUpdate();
			}
			
			conn.commit();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtils.close(conn, st, null);
		}
		
		
	}
	
	
}



