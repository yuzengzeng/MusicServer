<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cn.yzz.domain.News" %>
<%@page import="cn.yzz.domain.NewsList" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'ShowNewsList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		div{
		 padding-top: 20px;
		}
	</style>
	<script type="text/javascript">
		function onload(){
			
		};
	</script>
  </head>
  
  
  <body load="onload()">
    <h1 align="center">新闻列表</h1>
    
    <table align="center" width="80%" border="1">
    	<tr>
    		<th>标题</th>
    		<th>描述</th>
    		<th>日期</th>
    	</tr>
    	<c:forEach items="${newsList.list}" var="news" >
    		<tr>
    			<td>${news.title }</td>
    			<td>${news.description }</td>
    			<td>${news.date }</td>
    		</tr>
    	</c:forEach>
 	</table>
    <div align="CENTER" >
    	<a href="/day14/ObtainNewsServlet?pageNum=1&type=1&numPerPage=10">获取新闻列表</a>
    	&nbsp;&nbsp;第${newsList.pageNum }页,共${newsList.totlaPageNum }页 &nbsp;&nbsp;
    	<a href="/day14/ObtainNewsServlet?pageNum=${newsList.pageNum+1 }&type=1&numPerPage=10">下一页</a>
    	&nbsp;
    	<a href="/day14/ObtainNewsServlet?pageNum=${newsList.pageNum-1 }&type=1&numPerPage=10">上一页</a>
    </div>
    
  </body>
</html>
 	