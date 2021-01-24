package com.baidu.service;

import java.math.BigDecimal;
import java.util.List;


import com.baidu.dao.UserDAO;
import com.baidu.entity.Dept;
import com.baidu.entity.Power;
import com.baidu.entity.Role;
import com.baidu.entity.User;

public class UserService  {
	private UserDAO userDao;
	public List<Power> getPowerList() {
		// TODO Auto-generated method stub
		return userDao.getPowerList();
	}
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}
	public List<Dept> getDeptList() {
		// TODO Auto-generated method stub
		return userDao.getDeptList();
	}
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return userDao.getRoleList();
	}
	public List<User> getUserList(String did) {
		// TODO Auto-generated method stub
		return userDao.getUserList(did);
	}
	public String getIdByDeptid(String did) {
		// TODO Auto-generated method stub
		List list = userDao.getIdByDeptid(did);
		if(list!=null){
			String s1 = list.toString().replace(" ", "");
			return s1.substring(1, s1.length()-1);
		}
		return "";
	}
	public void saveyg(String did, String[] ids) {
		// TODO Auto-generated method stub
		userDao.deleteIdByDid(did);
		if(ids!=null&&ids.length>0){
			for(String id:ids){
				userDao.saveyg(did,id);
			}
		}
		
	}
	public String getRidByDeptid(String deptid) {
		// TODO Auto-generated method stub
		List list = userDao.getRidByDeptid(deptid);
		if(list!=null){
			String s = list.toString().replace(" ", "");
			return s.substring(1, s.length()-1);
		}
		
		return "";
	}
	public void savezw(String did, String[] ids) {
		// TODO Auto-generated method stub
		userDao.deleteRoleByDid(did);
		for(String rid:ids){
			userDao.savezw(did,rid);
		}
	}
	public List getRnames(Integer id) {
		// TODO Auto-generated method stub
		return userDao.getRnames(id);
	}
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}
	public List<Power> getPowerListByRid(String rid) {
		// TODO Auto-generated method stub
		List<Power> powerList = userDao.getPowerList();
		List<Integer> pids =userDao.getPidsByRid(rid);
		if(pids!=null&&pids.size()>0){
			
		
		for(Integer ps:pids){
			for(Power p:powerList){
				if(ps.intValue()==p.getId()){
					p.setChecked(true);
					break;
				}
			}
		}
		}
		return powerList;
	}
	public void saveQx(String rid, String[] pids) {
		// TODO Auto-generated method stub
		
		userDao.deleteQxByRid(rid);
		if(pids.length>0){
			
			for(String pid:pids){
				userDao.saveqx(rid,pid);
			}
		}
		
		
		
		
	}
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	public List<Dept> getDeptsById(String id) {
		// TODO Auto-generated method stub
		return userDao.getDeptsById(id);
	}
	public List<Power> getPowersById(String id) {
		// TODO Auto-generated method stub
		List<Power> powerList = userDao.getPowersById(id);
		List<Power> list = userDao.getPowerList();
		
		
			
		
		for(Power ps:list){
			for(Power p:powerList){
				if(ps.getId()==p.getId()){
					ps.setChecked(true);
					break;
				}
			}
		}
		return powerList;
	}
	public void saveRole(List<Role> list) {
		// TODO Auto-generated method stub
		for (Role role : list) {
			userDao.saveRole(role);
		}
	}
	
	
}
