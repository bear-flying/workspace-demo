package org.wangf.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.wangf.common.util.Page;

@Repository
public class PowerDaoImpl implements PowerDao{

		@Resource(name="sqlSessionTemplate")
		private SqlSessionTemplate sqlSessionTemplate;

		public List findPowerTree() {
			return sqlSessionTemplate.selectList("power.findTree");
		}
		
		public int findCountRole(Page page) {
			//Dao调用的时候 可以省去命名空间不写
			Object selectOne = sqlSessionTemplate.selectOne("findCountRole");
			int parseInt = Integer.parseInt(selectOne+"");
			return parseInt;
		}

		public List findRoleList(Page page) {
			List<Map> selectList = sqlSessionTemplate.selectList("findRoleList", page);
			return selectList;
		}
		
		public Boolean addRolePower(Map map) {
			String powerids = (String)map.get("powerids");
			String[] poweridss = powerids.split(",");
			
			System.out.println(poweridss);
			map.put("poweridss", poweridss);
			
			int insert = sqlSessionTemplate.insert("power.addRolePower", map);
			return insert>0?true:false;
		}
		
		public List findRolePower(String roleid) {
			List selectList = sqlSessionTemplate.selectList("findRolePower", roleid);
			return selectList;
		}
		
		public void deleteRolePowerById(String roleid) {
			sqlSessionTemplate.delete("deleteRolePowerById", roleid);
		}

		public List findPowerTreeByUserId(String userid) {
			return sqlSessionTemplate.selectList("power.findPowerTreeByUserId", userid);
		}
	
	
}
