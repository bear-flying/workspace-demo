<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<LINK 
href="images1/login.css" type=text/css rel=stylesheet>
<body>

<DIV id=div1>
  <table id=login height="100%" cellSpacing=0 cellPadding=0 width=800 
align=center>
    <TBODY>
      <TR id=main>
        <TD>
		<form method="post" action="user!login.action">	
          <table height="420" cellSpacing=0 cellPadding=0 width="784">
            <TBODY>
              <TR>
              </TR>
              <TR height=30>
                <TD width=380>&nbsp;</TD>
                <TD>&nbsp;</TD>
                <TD>&nbsp;</TD>
                <TD>&nbsp;</TD>
              </TR>
              <TR height=40>
                <TD rowSpan=4>&nbsp;</TD>
                <TD>用户名：</TD>
                <TD>
                  <INPUT class="textbox" type=text 
            name="name" value="${name }">
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=40>
                <TD>密　码：</TD>
                <TD>
                  <INPUT class="textbox" type=password 
            name="password">
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
			  
              <TR height=40>
                <TD>验证码：</TD>
                <TD vAlign=center colSpan=2>
                 <input type="text" name="yzm" style="width: 50px;" />
		    		<img id="kk" onclick="changeImage();" src="<%=request.getContextPath()%>/admin/image.jsp" />
		    		<a href="javascript:changeImage();">换一张</a></TD>
              </TR>
			  
              <TR height=40>
                <TD> <input type="checkbox" name="rem" value="yes"/>记住密码(一周)</TD>
                <TD align=center>
                
                  <INPUT  type=submit value=" 登 录 "/>
				  <INPUT  type=button value=" 注 册 " onclick="add()">
                </TD>
                <TD width=120 ></TD>
              </TR>
              <TR height=110>
                <TD colSpan=4 align="center"><h2 style="color: red">${msg}</h2></TD>
                
              </TR>
            </TBODY>
          </table>
		  </form>
        </TD>
      </TR>
      <TR id=root height=104>
        <TD>&nbsp;</TD>
      </TR>
    </TBODY>
  </table>
</DIV>




</body>
</html>