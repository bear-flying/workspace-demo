package com.jiangyu.utils;

import java.util.List;


/**
 * 小白侠专用分页类Struts2PageUtil<T>
 * by 1405javaB 姜宇 
 * 飞天猫熊 2015-09-07 by JiangYu
 */
public final class JiangYuPageUtil<T> {
	private Integer pageIndex;// 当前页的第一条数据在数据库的索引
	private String firstPage;// 首页
	private String prePage;// 上一页
	private String nextPage;// 下一页
	private String lastPage;// 尾页
	private Integer pageCount;// 数据库的数据在页面中展示的总页数
	private Integer currentPageNo;// 当前页的页码
	private Integer listCount;// 展示的数据库数据的总条数
	private String pageAll;//定义的一个字符串 包括（上一页、下一页……的超链接 ）
	private List<T> list;// 当前页展示的数据

	@SuppressWarnings("unused")
	private String ajaxPage;//ajax分页字符串
	
	/**
	 * 
	 * @param request
	 *            service的request请求
	 * @param listCount
	 *            展示的数据库的总条数
	 * @param onePageCount
	 *            分页时每一页展示的条数
	 * @param currentPageNo
	 *            当前分页的页码
	 * @param list
	 *            当前分页的展示数据,通常先计算通过sql语句在数据库中查出来返回一个list集合
	 * @param gongcheng
	 *            当前web project项目名
	 *            
	 * 小白侠专用分页类Struts2PageUtil<T>
	 * by 1405javaB 姜宇 
	 * 飞天猫熊 2015-09-07 by JiangYu
	 */
	public static <T> JiangYuPageUtil<T> page(String gongcheng, String namespace,
			String actionName, Integer listCount,
			Integer currentPageNo, Integer onePageCount, List<T> list) {
		JiangYuPageUtil<T> jiangYuPageUtil = new JiangYuPageUtil<T>();
		Integer pageCount = listCount < onePageCount ? 1 : (listCount
				/ onePageCount + (listCount % onePageCount == 0 ? 0 : 1));
		Integer pageIndex = (currentPageNo - 1) * onePageCount;
		String firstPage = "";
		String prePage = "";
		String nextPage = "";
		String lastPage = "";

		if (currentPageNo == 1) {
			firstPage = " 首页";
			prePage = " 上一页";
		} else {
			if (namespace == null) {
				firstPage = " <a href='/" + gongcheng + "/" + actionName
						+ "?page=1'>首页</a>";
				prePage = " <a href='/" + gongcheng + "/" + actionName
						+ "?page=" + (currentPageNo - 1)
						+ "'>上一页</a>";
			} else {
				firstPage = " <a href='/" + gongcheng + "/" + namespace + "/"
						+ actionName + "?page=1'>首页</a>";
				prePage = " <a href='/" + gongcheng + "/" + namespace + "/"
						+ actionName + "?page="
						+ (currentPageNo - 1) + "'>上一页</a>";

			}
		}

		if (currentPageNo == pageCount) {
			lastPage = " 末页";
			nextPage = " 下一页";
		} else {
			if (namespace == null) {
				lastPage = " <a href='/" + gongcheng + "/" + actionName
						+ "?page=" + pageCount + "'>末页</a>";
				nextPage = " <a href='/" + gongcheng + "/" + actionName
						+ "?page=" + (currentPageNo + 1)
						+ "'>下一页</a>";
			} else {
				lastPage = " <a href='/" + gongcheng + "/" + namespace + "/"
						+ actionName + "?page=" + pageCount
						+ "'>末页</a>";
				nextPage = " <a href='/" + gongcheng + "/" + namespace + "/"
						+ actionName + "?page="
						+ (currentPageNo + 1) + "'>下一页</a>";
			}
		}
		String as ="";
		String a ="";
		for(int i=1;i<=pageCount;i++){
			if(namespace == null){
				a = " <a href='/" + gongcheng + "/" 
						+ actionName + "?page="
						+  i  + "'>"+i+"</a> ";
			}else{
				a = " <a href='/" + gongcheng + "/" + namespace + "/"
						+ actionName + "?page="
						+  i  + "'>"+i+"</a> ";
			}
			
			as = as + a;
		}
		// 例如：1/3页
		String pageAll = "共" + listCount + "条数据 " + currentPageNo + " / "
				+ pageCount + "页 " + firstPage + prePage + as +nextPage + lastPage;

		jiangYuPageUtil.setPageIndex(pageIndex);// 当前页的第一条数据在数据库的索引
		jiangYuPageUtil.setFirstPage(firstPage);// 首页信息
		jiangYuPageUtil.setPrePage(prePage);// 上一页的信息
		jiangYuPageUtil.setNextPage(nextPage);// 下一页的信息
		jiangYuPageUtil.setLastPage(lastPage);// 尾页的信息
		jiangYuPageUtil.setPageCount(pageCount);// 数据库的数据在页面中展示的总页数
		jiangYuPageUtil.setCurrentPageNo(currentPageNo); // 当前页的页码
		jiangYuPageUtil.setListCount(listCount); // 展示的数据库数据的总条数
		jiangYuPageUtil.setPageAll(pageAll);
		jiangYuPageUtil.setList(list);// 当前页展示的数据
		return jiangYuPageUtil;
	}

	//AJAX分页
	public String getAjaxPage() {
		
		if(currentPageNo==1) {
			firstPage="首页";
			prePage="上一页";
        }else{
        	firstPage="<a href='javaScript:void(0)' onclick='goPage("+1+")'>首页</a> ";
        	prePage="<a href='javaScript:void(0)' onclick='goPage("+(getCurrentPageNo()-1)+")'>上一页</a> ";
        }
		
		String bs ="";
		String b ="";
		for(int i=1;i<=getPageCount();i++){
			if(i == getCurrentPageNo()){
				b= i +"";
			}else{
				b = "<a href='javaScript:void(0)' onclick='goPage("+i+")'>"+i+"</a> ";
			}
			
			bs = bs +"  "+ b;
		}
		
		if(currentPageNo==getPageCount() || getPageCount()==1) {
			lastPage= "末页";
	       	nextPage="下一页";
	    }else{
	    	lastPage= "<a href='javaScript:void(0)' onclick='goPage("+getPageCount()+")'>末页</a> ";
	        nextPage="<a href='javaScript:void(0)' onclick='goPage("+(getCurrentPageNo()+1)+")'>下一页</a> ";
	    }
		
		return  "总记录数"+ getListCount()+" "+
				"当前页"+getCurrentPageNo()+"/"+getPageCount()+"  "+
				firstPage +" "+ prePage +" "+ bs +" "+ nextPage + " "+ lastPage;
		
	}
	
	
	public void setAjaxPage(String ajaxPage) {
		this.ajaxPage = ajaxPage;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(String firstPage) {
		this.firstPage = firstPage;
	}

	public String getPrePage() {
		return prePage;
	}

	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public String getLastPage() {
		return lastPage;
	}

	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public Integer getListCount() {
		return listCount;
	}

	public void setListCount(Integer listCount) {
		this.listCount = listCount;
	}

	public String getPageAll() {
		return pageAll;
	}

	public void setPageAll(String pageAll) {
		this.pageAll = pageAll;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
