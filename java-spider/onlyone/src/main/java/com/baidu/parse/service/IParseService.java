package com.baidu.parse.service;

import java.util.List;

import com.baidu.parse.pojo.App;
import com.baidu.parse.pojo.Comment;
import com.baidu.parse.pojo.Pic;

public interface IParseService {

	void addPic(Pic pic);

	void addComment(Comment comment);

	void addApp(App app);

	List<App> seletApps();

}
