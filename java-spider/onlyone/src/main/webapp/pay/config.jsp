<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<% 

//收款方
String spname = "财付通双接口测试";  

//商户号
String partner = "1900000113";

//密钥
String key = "e82573dc7e6136ba414f2e2affbe39fa";

//交易完成后跳转的URL
String return_url = "http://127.0.0.1/onlyone/pay/payReturnUrl.jsp";

//接收财付通通知的URL
String notify_url = "http://127.0.0.1/onlyone/pay/payNotifyUrl.jsp";

%>
