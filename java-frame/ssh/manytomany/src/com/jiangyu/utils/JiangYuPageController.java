package com.jiangyu.utils;

import java.io.IOException;
//import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * 分页工具类
 * 
 * 小白侠专用分页工具类JiangYuAjaxUtils<T>
 * by 1405javaB 姜宇 
 * 飞天猫熊 2015-10-11 by JiangYu
 * 
 * 注意：不允许删改此注释！不允许改名！否则你将受到法老王的诅咒！！
 */
public class JiangYuPageController extends BodyTagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String url;

	public int doStartTag() throws JspException {
		StringBuffer html = new StringBuffer("");
		int pageNo = 1;
		int pageSize = 10;
		int pageCount = 0;
		int totalCount = 0;
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		//设置路径
		this.url = request.getContextPath()+"/"+this.url;
//		Enumeration<String> enum_ = request.getAttributeNames();
//		BaseListBean baseListBean = null;
//		while(enum_.hasMoreElements()){
//			String attrName = enum_.nextElement();
//			Object obj = request.getAttribute(attrName);
//			if(obj instanceof BaseListBean){
//				baseListBean = (BaseListBean) obj;
//				pageNo = baseListBean.getAbstractData().getPageNo();
//				pageSize = baseListBean.getAbstractData().getPageSize();
//				pageCount = baseListBean.getAbstractData().getPageCount();
//				totalCount = baseListBean.getAbstractData().getTotalCount();
//			}
//		}
		
		StringBuffer selHtml = new StringBuffer();
		selHtml.append("<select name=\"pageSize\" onchange=\"goPage(1)\">");
		if(pageSize==10){
			selHtml.append("<option value=\"10\" selected>10</option><option value=\"20\">20</option><option value=\"50\">50</option>");
		}
		if(pageSize==20){
			selHtml.append("<option value=\"10\">10</option><option value=\"20\" selected>20</option><option value=\"50\">50</option>");
		}
		if(pageSize==50){
			selHtml.append("<option value=\"10\">10</option><option value=\"20\">20</option><option value=\"50\" selected>50</option>");
		}
		selHtml.append("</select>");
		
		//加入分页参数隐藏域
		html.append("<input type=\"hidden\" name=\"pageNo\" value=\""+pageNo+"\">");
		//html.append("<input type=\"hidden\" name=\"pageSize\" value=\""+pageSize+"\">");
		html.append("<input type=\"hidden\" name=\"pageCount\" value=\""+pageCount+"\">");
		
        html.append("\r\n");
        html.append("   \t\t</table>\r\n");
        html.append("   \t\t\r\n");
        html.append("   \t\t<table align=\"center\">\r\n");
        html.append("   \t\t\t<tr>\r\n");
        html.append("   \t\t\t\t<td>\r\n");
        html.append("   \t\t\t\t\t<a href=\"javascript:goPage(1)\">首页</a>\r\n");
        html.append("\t   \t\t\t\t<a href=\"javascript:goPage("+((pageNo-1)>0?(pageNo-1):1)+")\">上一页</a>\r\n");
        html.append("\t   \t\t\t\t<a href=\"javascript:goPage("+((pageNo+1)<pageCount?pageNo+1:pageCount)+")\">下一页</a>\r\n");
        html.append("\t   \t\t\t\t<a href=\"javascript:goPage("+pageCount+")\">尾页</a>\r\n");
        html.append("\t   \t\t\t\t共"+totalCount+"条"+pageCount+"页\r\n");
        html.append("\t每页显示");
        html.append(selHtml.toString());
        html.append("条");
        html.append("\t   \t\t\t\t<input type=\"text\" value=\"\" name=\"gopageCount\" size=\"1\" >\r\n");
        html.append("\t   \t\t\t\t<input type=\"button\" value=\"go\" name=\"pgBn\" onclick=\"goPage(gopageCount.value)\">\r\n");
        html.append("   \t\t\t\t</td>\r\n");
        html.append("   \t\t\t</tr>\r\n");
        html.append("   \t\t</table>\r\n");
        html.append("   \t\t\r\n");
        html.append("   \t");
        
        html.append("<script type=\"text/javascript\">\r\n");
        html.append("function goPage(pageno){\r\n");
       // html.append("alert(pageno){\r\n");
        html.append("	var length = pageno.length;"+
					"   var flag = false; "+
					"   for(var i=0;i<length;i++){ "+
					"   	var c = pageno.charAt(i); "+
					"   	if(c<'0' || c>'9'){ "+
					" 	  	flag = true; "+
					" 	  } "+
					"   } "+
					"   if(parseInt(pageno)==0){ "+
					"   	pageno = parseInt(pageno)+1; "+
					"   } "+
					"	if(flag){ "+
					"   	alert('页码必须是数字！'); "+
					" 	  return; "+
					"   }");
        html.append("\tvar form = document.forms[0];\r\n");
        html.append("\tvar pageCount = form.pageCount.value;\r\n");
        html.append("\tif(parseInt(pageno)>parseInt(pageCount)){\r\n\talert('页码不能大于总页数"+pageCount+"!');\r\n \t return;\r\n}");
        html.append("\tform.pageNo.value = pageno;\r\n");
        html.append("\tform.action = '"+this.url+"';\r\n");
        html.append("\tform.submit();\r\n");
        html.append("}\r\n");
        html.append("</script>\r\n");
        /**
         * 分页工具类
         * 
         * 小白侠专用分页工具类JiangYuAjaxUtils<T>
         * by 1405javaB 姜宇 
         * 飞天猫熊 2015-10-11 by JiangYu
         * 
         * 注意：不允许删改此注释！不允许改名！否则你将受到法老王的诅咒！！
         */
		try {
			pageContext.getOut().print(html.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 分页工具类
	 * 
	 * 小白侠专用分页工具类JiangYuAjaxUtils<T>
	 * by 1405javaB 姜宇 
	 * 飞天猫熊 2015-10-11 by JiangYu
	 * 
	 * 注意：不允许删改此注释！不允许改名！否则你将受到法老王的诅咒！！
	 */
}
