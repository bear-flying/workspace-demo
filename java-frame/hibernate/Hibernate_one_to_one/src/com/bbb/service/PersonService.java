package com.bbb.service;

import com.bbb.dao.PersonDAO;
import com.bbb.dto.Card;
import com.bbb.dto.Person;

public class PersonService {
	private PersonDAO dao = new PersonDAO();
	public void savePerson(Card card,Person person){
		dao.savePerson(card,person);	
	}
	
	
	//ÐÞ¸Ä
	public void updatePerson(Card card,Person person){
		dao.updatePerson(card,person);
	}
}
