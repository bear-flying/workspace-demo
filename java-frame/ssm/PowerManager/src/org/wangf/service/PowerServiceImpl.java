package org.wangf.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wangf.common.util.Page;
import org.wangf.dao.PowerDao;

@Service
@Transactional(readOnly=true)
public class PowerServiceImpl implements PowerService{
	@Autowired
	private PowerDao powerDao;
	public List findPowerTree() {
		return powerDao.findPowerTree();
	}
	
	public Page findRoleList(Page page) {

		// 1 获取总页数
		int count = powerDao.findCountRole(page);
		page = new Page(page.getCpage(), count, page.getPageSize());
		// dangqian 业的数据
		List list = powerDao.findRoleList(page);
		page.setList(list);
		return page;
	}
	@Transactional(readOnly=false)
	public Boolean addRolePower(Map map) {
		Object roleid = map.get("roleid");
		powerDao.deleteRolePowerById(roleid.toString());
		return powerDao.addRolePower(map);
	}
	
	public List findRolePower(String roleid) {
		return powerDao.findRolePower( roleid);
	}

	public List findPowerTreeByUserId(String userid) {
		return powerDao.findPowerTreeByUserId(userid);
	}

}
