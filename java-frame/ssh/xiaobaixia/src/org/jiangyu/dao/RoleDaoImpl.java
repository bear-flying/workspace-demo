package org.jiangyu.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.jiangyu.pojo.Role;
import org.springframework.stereotype.Repository;
import org.xiaobaixia.jiangyu.ssh3.utils.JiangYuSpringDao;
@Repository("roleDao")
public class RoleDaoImpl extends JiangYuSpringDao<Role> implements RoleDao {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		
		super.setSuperSessionFactory(sessionFactory);
		
	}
}
