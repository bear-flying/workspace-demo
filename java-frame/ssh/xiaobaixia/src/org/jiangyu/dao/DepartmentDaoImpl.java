package org.jiangyu.dao;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.jiangyu.pojo.Department;
import org.springframework.stereotype.Repository;
import org.xiaobaixia.jiangyu.ssh3.utils.JiangYuSpringDao;


@Repository("departmentDao")
public class DepartmentDaoImpl extends JiangYuSpringDao<Department> implements
		DepartmentDao {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		
		super.setSuperSessionFactory(sessionFactory);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findTopList() {

		String hql = "FROM Department d WHERE d.parent is NULL";

		return (List<Department>) this.getSession().createQuery(hql).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findChildren(Long parentId) {

		String hql = "FROM Department d WHERE d.parent.id = ?";

		return (List<Department>) this.getSession().createQuery(hql)
				.setParameter(0, parentId).list();
	}
	
}
