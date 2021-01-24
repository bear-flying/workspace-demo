package com.founder.pojo;

import java.util.ArrayList;
import java.util.List;

public class ResponseArticle {

	private List<ResponseState> articleStates = new ArrayList<>();

	
	public List<ResponseState> getArticleStates() {
		return articleStates;
	}

	public void setArticleStates(List<ResponseState> articleStates) {
		this.articleStates = articleStates;
	}
	
}
