<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	 function check(){
		 var form=document.getElementById("form1");
		
		 var name=document.getElementById("name").value;
		 var password=document.getElementById("password").value;
		 if(name==""||password==""){
			alert("用户名和密码均不能为空，请重新填写");
			 return false;
		 }else{
			 form.submit();
		 }
	 }
	</script>

  </head>
  
  <body>
  <center>
  
  
 
   <h1>用户登录</h1>
   <div style="color: red;">${msg }</div>
   <form action="/day14/LoginServlet" id="form1"  method="post" style="margin: auto;">
   		用户名：<input type="text" name="username" value="${form.username }" id="name"/><br>
   		密&nbsp;&nbsp;码：<input type="password" name="password" value="${form.password }" id="password"/><br>
   		<input type="button" width="40px" height="25px" value="登录" onclick="check()"><br>
   </form>
   
   
    </center>
  </body>
</html>
