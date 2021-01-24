<%--
  itcast.cn的ajax自动补全实例
--%>
<!--与传统应用的视图层不同 ，这个jsp返回的是xml的数据，因此contentType的值是text/xml-->
<%@ page contentType="text/xml;charset=UTF-8" language="java" %>
<!--返回xml数据的‘视图层暂时不做任何逻辑判断，先将所有单词都返回，待前后台应用可以完整的协作之后，再限制返回的内容’-->
<%
	//页面端传送的字符串
	String word = (String)request.getAttribute("word");
%>
<words>
	<%if("absolute".startsWith(word)){%>
   		<word>absolute</word>
    <%}%>
    
    <%if("anyone".startsWith(word)){%>
    	<word>anyone</word>
    <%}%>
    
    <%if("anything".startsWith(word)){%>
    	<word>anything</word>
    <%}%>
    
    <%if("apple".startsWith(word)){%>
    	<word>apple</word>
    <%}%>
    
    <%if("abandon".startsWith(word)){%>
    	<word>abandon</word>
    <%}%>
    
    <%if("breach".startsWith(word)){%>
    	<word>breach</word>
    <%}%>
    
    <%if("break".startsWith(word)){%>
    	<word>break</word>
    <%}%>
    
    <%if("boolean".startsWith(word)){%>
    	<word>boolean</word>
    <%}%>
</words>
<!-- 
	总结:这里最好还是采用MVC模式，即在Servlet中完成数据的筛选，然后
	在此JSP页面中仅仅是用JSTL标签迭代生成XML数据。
 -->