package com.baidu.parse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.parse.dao.ICommentDao;
import com.baidu.parse.dao.IParseDao;
import com.baidu.parse.dao.IPicDao;
import com.baidu.parse.pojo.App;
import com.baidu.parse.pojo.Comment;
import com.baidu.parse.pojo.Pic;

@Service
public class ParseService implements IParseService {

	@Autowired
	private IParseDao parseDao;
	@Autowired
	private IPicDao picDao;
	@Autowired
	private ICommentDao commentDao;
	
	@Override
	public void addPic(Pic pic) {
		// TODO Auto-generated method stub
		picDao.addPic(pic);
	}

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.addComment(comment);
	}

	@Override
	public void addApp(App app) {
		// TODO Auto-generated method stub
		try {
			parseDao.addApp(app);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<App> seletApps() {
		// TODO Auto-generated method stub
		
		
		return parseDao.selectApps();
	}
	
	
	
}
