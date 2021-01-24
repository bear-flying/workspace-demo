package com.javase.collention;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student a1,Student a2) {
		
		return (int)(a1.getScore()-a2.getScore());
	}

	
}
