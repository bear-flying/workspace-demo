package com.baidu.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baidu.entity.Dept;
import com.baidu.entity.Power;
import com.baidu.entity.Role;
import com.baidu.entity.User;
public class UserDAO extends HibernateDaoSupport{

	/*@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}*/
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:权限列表
	 */
	public List<Power> getPowerList() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Power").list();
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from User").list();
	}

	public List<Dept> getDeptList() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Dept").list();
	}

	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Role").list();
	}

	public List<User> getUserList(String did) {
		// TODO Auto-generated method stub
		String sql="select a.* from t_user a,t_user_dept b,t_dept c where a.id =b.id and c.deptid=b.did and c.deptid="+did;
		return getSession().createSQLQuery(sql).addEntity(User.class).list();
	}

	public List getIdByDeptid(String did) {
		// TODO Auto-generated method stub
		List list = getSession().createSQLQuery("select id from t_user_dept where did="+did).list();
		
		return list.size()==0?null:list;
	}

	public void saveyg(String did, String id) {
		// TODO Auto-generated method stub
		getSession().createSQLQuery("insert into t_user_dept (id,did) values("+id+","+did+")").executeUpdate();
	}

	public void deleteIdByDid(String did) {
		// TODO Auto-generated method stub
		getSession().createSQLQuery("delete from t_user_dept where did="+did).executeUpdate();
	}

	public List getRidByDeptid(String deptid) {
		// TODO Auto-generated method stub
		 List list = getSession().createSQLQuery("select rid from t_dept_role where deptid="+deptid).list();
		 return list.size()==0?null:list;
	}

	public void deleteRoleByDid(String did) {
		// TODO Auto-generated method stub
		getSession().createSQLQuery("delete from t_dept_role where deptid="+did).executeUpdate();
	}

	public void savezw(String did, String rid) {
		// TODO Auto-generated method stub
		getSession().createSQLQuery("insert into t_dept_role (deptid,rid) values("+did+","+rid+")").executeUpdate();
	}

	public List getRnames(Integer id) {
		// TODO Auto-generated method stub
		String sql="select distinct a.rname from t_role a,t_user b,t_user_dept c,t_dept d,t_dept_role e where "+
		"b.id=c.id and c.did=d.deptid and d.deptid= e.deptid and a.rid =e.rid and b.id="+id;
		return getSession().createSQLQuery(sql).list();
	}

	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		List<User> list = getHibernateTemplate().find("from User where name =?",name);
		return list.size()==1?list.get(0):null;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		getSession().update(user);
	}

	public List getPidsByRid(String rid) {
		// TODO Auto-generated method stub
		List list = getSession().createSQLQuery("select id from t_role_power where rid ="+rid).list();
		
		return list;
	}

	public void saveqx(String rid, String pid) {
		// TODO Auto-generated method stub
		getSession().createSQLQuery("insert into t_role_power (rid,id) values("+rid+","+pid+")").executeUpdate();
	}

	

	public void deleteQxByRid(String rid) {
		// TODO Auto-generated method stub
		getSession().createSQLQuery("delete from t_role_power where rid ="+rid).executeUpdate();
	}

	public User getUserById(String id) {
		// TODO Auto-generated method stub
		List<User> list =getSession().createQuery("from User where id ="+id).list();
		return list.size()==1?list.get(0):null;
	}

	public List<Dept> getDeptsById(String id) {
		// TODO Auto-generated method stub
		String sql="select a.* from t_dept a,t_user_dept b,t_user c where a.deptid=b.did and b.id=c.id and c.id ="+id;
		
		
		return getSession().createSQLQuery(sql).addEntity(Dept.class).list();
	}

	public List<Power> getPowersById(String id) {
		// TODO Auto-generated method stub
		String sql="select distinct a.* from t_power a,t_role_power b,t_role c ,t_dept_role d,t_dept e,t_user_dept f,t_user g where "+
		" a.id = b.id and b.rid = c.rid and c.rid = d.rid and d.deptid = e.deptid and e.deptid=f.did and f.id = g.id and g.id="+id;
		return getSession().createSQLQuery(sql).addEntity(Power.class).list();
	}

	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		
		getSession().save(role);
	}

	
}
