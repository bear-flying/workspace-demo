package org.wangf.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.wangf.common.util.Page;

public interface PowerService {
	public List findPowerTree();
	
	Page findRoleList(Page page);
	
	Boolean addRolePower(Map map);
	
	List findRolePower(String roleid);
	
	public List findPowerTreeByUserId(String userid);
}
