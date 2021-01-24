package com.xiaobai.utils;




import javax.servlet.http.HttpServletRequest;

public class ToolPage {
	
	public static void page(HttpServletRequest request, int page, int pageSize, String url, int totalNums) {
		//4个元素的字符串数组, 用来存放html页面上的首页、上一页、下一页和末页
		String[] pageArray = new String[4];
		//总页数
		int totalPages =  totalNums / pageSize + (totalNums % pageSize != 0 ? 1 : 0);
		//url传参标记
		String flag = url.indexOf("?") > -1 ? "&" : "?";
		
		if (page == 1) {
			pageArray[0] = "首页";
		} else {
			pageArray[0] = "<a href=\"" + request.getContextPath() + "/" + url + flag + "page=1\">首页</a>";
		}
		
		if (page == 1) {
			pageArray[1] = "上一页";
		} else {
			pageArray[1] = "<a href=\"" + request.getContextPath() + "/" + url + flag + "page=" + (page - 1) + "\">上一页</a>";
		}
		
		if (page < totalPages) {
			pageArray[2] = "<a href=\"" + request.getContextPath() + "/" + url + flag + "page=" + (page + 1) + "\">下一页</a>";
		} else {
			pageArray[2] = "下一页";
		}
		
		if (page < totalPages) {
			pageArray[3] = "<a href=\"" + request.getContextPath() + "/" + url + flag + "page=" + totalPages + "\">末页</a>";
		} else {
			pageArray[3] = "末页";
		}
		String 首页 = pageArray[0];
		String 上一页 = pageArray[1];
		String 下一页 = pageArray[2];
		String 末页 = pageArray[3];
		//首页
		request.setAttribute("firstPage", 首页);
		//上一页
		request.setAttribute("prevPage", 上一页);
		//下一页
		request.setAttribute("nextPage", 下一页);
		//末页
		request.setAttribute("lastPage", 末页);
		//当前页
		request.setAttribute("page", page);
		//总页数
		request.setAttribute("totalPages", String.valueOf(totalPages));
		//总记录数
		request.setAttribute("totalNums", totalNums);
		//每一页显示记录
		request.setAttribute("pageSize", pageSize);
		//request.setAttribute("list", list);
		request.setAttribute("pageAll",首页 +" " + 上一页 +" " + 下一页 +" " + 末页 +"    共"+totalNums+"条数据         "+"   第"+page+"/"+totalPages+"页");
	}
}