<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'regist.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
	<script type="text/javascript">
		function change(){
			var img=document.getElementById("verifyCode");
			var number=Math.random();
			img.src="/day14/VerifyCodeServlet?number="+number;
		}
	</script>
	
	<style type="text/css">
		center {
			border: 2px;
		}
	</style>

</head>

<body>

	
	
	<h1>注册</h1>
	<p style="color:red;font-weight: 900">${msg }</p>
	<form action="/day14/RegistServlet" method="post">
		用户名：<input type="text" name="username" value="${username }"/>${errors.username }<br /> 
		密 &nbsp;码：<input type="password" name="password" value="${password }"/>${errors.password }<br /> 
		验证码:<input type="text" name="verifyCode" />
		<img  id="verifyCode" alt="" src="<c:url value='/VerifyCodeServlet'/>">
		<a href="javascript:change()">看不清，换一张</a>${errors.verifyCode }<br/>
		&nbsp;&nbsp;<input type="submit" value="注册" />
	</form>
	
</body>
</html>
