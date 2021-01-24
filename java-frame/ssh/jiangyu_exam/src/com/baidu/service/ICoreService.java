package com.baidu.service;

import java.util.List;
import java.util.Set;

import com.baidu.pojo.Academy;
import com.baidu.pojo.Classes;
import com.baidu.pojo.Hobby;
import com.baidu.pojo.Student;

public interface ICoreService {

	List<Student> findAll(Integer page, Integer pageSize);

	int getCount();

	List<Academy> findAllAcademy();

	List<Classes> findClassByAcad(Integer acadid);

	void add(Student student, Integer[] cats);

	Student findOne(Integer id);

	Set<Hobby> findHobbys(Integer id);

	void modify(Student student, Integer[] cats);

}
