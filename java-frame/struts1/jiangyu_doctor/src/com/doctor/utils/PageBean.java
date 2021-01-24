package com.doctor.utils;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	
	//1.鏌ヨ绗嚑椤�
	private int page ;
	//2.姣忛〉澶氬皯鏉℃暟鎹�
	private int pageSize ;
	//3.瀛樻斁褰撳墠椤电殑鏁版嵁鐨勯泦鍚�
	private List<T> list = new ArrayList<T>()	;
	//4.鎬诲叡澶氬皯椤�
	private int totalPages ;
	//5.鎬诲叡澶氬皯鏉℃暟鎹�
	private int totalNums ;
	//6.姣忛〉瀹為檯澶氬皯鏉℃暟鎹�
	private int actualPageSize ;

	
	/*
	 * 褰撹姹傝姹傛煡璇㈤〉鏁板皬浜庣瓑浜庨椤�杩斿洖棣栭〉 
	 * 褰撹姹傝姹傛煡璇㈤〉鏁板ぇ浜庣瓑浜庡熬椤佃繑鍥炲熬椤�
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
	 * 鏄惁鏈変笅涓�〉
	 */
	public boolean isHasNext(){
		if(getPage() < getTotalPages()){
			return true;
		}
		return false;
	}
	
	/*
	 * 鏄惁鏈変笂涓�〉
	 */
	public boolean isHasPrev(){
		if(getPage() > 1){
			return true;
		}
		return false;
	}
	
	/*
	 * 鑾峰彇涓婁竴椤�
	 */
	public int getPrevPage(){
		if(isHasPrev()){
			return getPage() - 1;
		}
		return getPage();
	}
	
	/*
	 * 鑾峰彇涓嬩竴椤�
	 */
	public int getNextPage(){
		if(isHasNext()){
			return getPage() + 1;
		}
		return getPage();
	}
	
	

}
