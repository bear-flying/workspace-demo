package com.baidu.bmx.utils;

import java.util.ArrayList;
import java.util.List;
public class PageBean<T>  {
	
	/**
	 * 分页
	 */
	
	//当前页
	private int page=1 ;
	//每页显示数
	private int pageSize ;
	
	private List<T> list = new ArrayList<T>()	;
	//总页数
	private int totalPages ;
	//总记录数
	private int totalNums ;
	//每页真实数据数
	private int actualPageSize ;
	//分页
	private String url;
	
	
   @SuppressWarnings("unused")
    private String pageing;
    private String pageIndex;
    private String before;
    private String next;
    private String last;
  
  
	public String getPageing() {
		String flag = null;
		 if(url!=null&&!"".equals(url)){  flag = url.indexOf("?") > -1 ? "&" : "?";}
		if(page==1&&getPrevPage()==1) {
       	 pageIndex= "<a>首页</a>";
       	 before="<a>上一页</a>";
        }else{
        	pageIndex=	"<a href='"+ url+flag+"page=1'>首页</a>";
        	before="<a href='"+ url+flag+"page="+getPrevPage()+"'>上一页</a> ";
        }
		if((page==getTotalPages()&&getNextPage()==getTotalPages())||getTotalPages()==0) {
	       	 last= "<a>末页</a>";
	       	 next="<a>下一页</a>";
	        }else{
	        	last= "<a href='"+ url+flag+"page="+getTotalPages()+"'>末页</a> ";
		       	 next="<a href='"+ url+flag+"page="+getNextPage()+"'>下一页</a> ";
	        }
	return  "总记录数"+ getTotalNums()+" "+
			"当前页"+getPage()+"/"+getTotalPages()+""+
         
	
			pageIndex +
    before 
     +next+
    last;
    
    
}

   

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

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
