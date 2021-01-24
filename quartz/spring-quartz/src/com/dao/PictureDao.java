package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entity.Picture;

@Component("dao")
public class PictureDao {
	@Resource
	private SessionFactory mySessionFactory;
	@Resource
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<Picture> list() {
		Session session = mySessionFactory.getCurrentSession();
		String hql = "from Picture";
		Query query = session.createQuery(hql);
		query.setCacheable(true);
		List<Picture> list = query.list();
		return list;
	}

	public void addPicture(Picture picture) {

		hibernateTemplate.save(picture);
	}
}
