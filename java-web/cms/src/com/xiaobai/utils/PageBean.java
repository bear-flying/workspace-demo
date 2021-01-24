package com.xiaobai.utils;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	
	//1.查询第几页
	private int page ;
	//2.每页多少条数据
	private int pageSize ;
	//3.存放当前页的数据的集合
	private List<T> list = new ArrayList<T>()	;
	//4.总共多少页
	private int totalPages ;
	//5.总共多少条数据
	private int totalNums ;
	//6.每页实际多少条数据
	private int actualPageSize ;

	
	/*
	 * 当请求要求查询页数小于等于首页 返回首页 
	 * 当请求要求查询页数大于等于尾页返回尾页
	 */
	public int getPage() {
		if(page <= 1)
		{
			page = 1 ;
		}
		else if(page >= totalPages)
		{
			page = totalPages;
		}
		
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalNums() {
		return totalNums;
	}

	public void setTotalNums(int totalNums) {
		this.totalNums = totalNums;
	}

	public int getActualPageSize() {
		return actualPageSize;
	}

	public void setActualPageSize(int actualPageSize) {
		this.actualPageSize = actualPageSize;
	}
	
	/*
	 * 是否有下一页
	 */
	public boolean isHasNext(){
		if(getPage() < getTotalPages()){
			return true;
		}
		return false;
	}
	
	/*
	 * 是否有上一页
	 */
	public boolean isHasPrev(){
		if(getPage() > 1){
			return true;
		}
		return false;
	}
	
	/*
	 * 获取上一页
	 */
	public int getPrevPage(){
		if(isHasPrev()){
			return getPage() - 1;
		}
		return getPage();
	}
	
	/*
	 * 获取下一页
	 */
	public int getNextPage(){
		if(isHasNext()){
			return getPage() + 1;
		}
		return getPage();
	}
	
	

}
