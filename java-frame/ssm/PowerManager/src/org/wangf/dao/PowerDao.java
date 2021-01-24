package org.wangf.dao;

import java.util.List;
import java.util.Map;

import org.wangf.common.util.Page;

public interface PowerDao {
	//²éÑ¯power±íµÄÊ÷
	public List findPowerTree();
	
	int findCountRole(Page page);

	List findRoleList(Page page);
	
	Boolean addRolePower(Map map);
	
	List findRolePower(String roleid);
	
	void deleteRolePowerById(String roleid);
	
	public List findPowerTreeByUserId(String userid);
	
}
