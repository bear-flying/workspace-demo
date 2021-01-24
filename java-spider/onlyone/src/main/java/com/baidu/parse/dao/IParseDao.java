package com.baidu.parse.dao;

import java.util.List;

import com.baidu.parse.pojo.App;

public interface IParseDao {

	void addApp(App app);

	List<App> selectApps();

}
