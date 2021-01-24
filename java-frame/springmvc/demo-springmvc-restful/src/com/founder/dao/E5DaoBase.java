package com.founder.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

@Component
public class E5DaoBase {

	//sessionTemplateMysql代表的是翔宇5.0的数据库
	@Resource(name="mySqlSessionTemplate")
	private SqlSessionTemplate sessionTemplateMysql;

	public SqlSessionTemplate getSessionTemplateMysql() {
		return sessionTemplateMysql;
	}

	public void setSessionTemplateMysql(SqlSessionTemplate sessionTemplateMysql) {
		this.sessionTemplateMysql = sessionTemplateMysql;
	}
	

}
