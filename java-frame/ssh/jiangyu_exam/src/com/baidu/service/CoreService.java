package com.baidu.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.IAcademyDao;
import com.baidu.dao.IClassesDao;
import com.baidu.dao.IStudentDao;
import com.baidu.pojo.Academy;
import com.baidu.pojo.Classes;
import com.baidu.pojo.Hobby;
import com.baidu.pojo.Student;
@Service
public class CoreService implements ICoreService {

	@Autowired
	private IStudentDao studentDao;
	@Autowired
	private IAcademyDao academyDao;
	@Autowired
	private IClassesDao classesDao;
	
	public List<Student> findAll(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return studentDao.queryPage(" FROM Student ", page, pageSize);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return studentDao.getCount(Student.class);
	}

	public List<Academy> findAllAcademy() {
		// TODO Auto-generated method stub
		return academyDao.findAll(" FROM Academy ");
	}

	public List<Classes> findClassByAcad(Integer acadid) {
		//String sql = "select c.id,c.cname from t_class c left join t_academy a on c.aid=a.id where a.id = "+acadid;
		//String sql = " from Classes ";
		String sql = "select c.* from t_class c where c.aid ="+acadid;
		return classesDao.findAllBySql(Classes.class, sql);
				//classesDao.findAll(sql);
	}

	public void add(Student student, Integer[] cats) {
		// TODO Auto-generated method stub
		Set<Hobby> set = new HashSet<Hobby>();
		for (Integer ca : cats) {
			set.add(new Hobby(ca));
		}
		student.setHobbys(set);
		studentDao.addOne(student);
	}

	public Student findOne(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.get(Student.class, id);
	}

	public Set<Hobby> findHobbys(Integer id) {
		// TODO Auto-generated method stub
		Student ss = studentDao.get(Student.class, id);
		Set<Hobby> hobbys = ss.getHobbys();
		return hobbys ;
	}

	public void modify(Student student, Integer[] cats) {
		// TODO Auto-generated method stub
		Set<Hobby> set = student.getHobbys();
		set.clear();
		for (Integer ca : cats) {
			set.add(new Hobby(ca));
		}
		student.setHobbys(set);
		studentDao.modify(student);
	}

}
