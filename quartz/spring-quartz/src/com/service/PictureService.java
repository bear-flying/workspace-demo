package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dao.PictureDao;
import com.entity.Picture;

@Component("service")
public class PictureService {
	@Resource(name = "dao")
	private PictureDao dao;

	public void addPicture(Picture picture) {
		dao.addPicture(picture);
	}

	public List<Picture> list() {
		return dao.list();
	}

}
