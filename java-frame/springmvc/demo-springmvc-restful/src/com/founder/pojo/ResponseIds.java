package com.founder.pojo;

import java.util.ArrayList;
import java.util.List;

public class ResponseIds {

	List<Integer> articleIds = new ArrayList<>();
	
	ResponseState reponseState;


	public List<Integer> getArticleIds() {
		return articleIds;
	}

	public void setArticleIds(List<Integer> articleIds) {
		this.articleIds = articleIds;
	}

	public ResponseState getReponseState() {
		return reponseState;
	}

	public void setReponseState(ResponseState reponseState) {
		this.reponseState = reponseState;
	}
	
}
