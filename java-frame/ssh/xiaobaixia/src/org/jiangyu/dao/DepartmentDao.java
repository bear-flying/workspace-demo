package org.jiangyu.dao;

import java.util.List;

import org.jiangyu.pojo.Department;
import org.xiaobaixia.jiangyu.ssh3.utils.JiangYuIspringDao;



public interface DepartmentDao extends JiangYuIspringDao<Department> {


	public List<Department> findTopList();
	
	public List<Department> findChildren(Long parentId);
}
