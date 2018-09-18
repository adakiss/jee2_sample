<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="hu.adakiss.sample.dalmock.Hero" %>
<% List<Hero> heroes = (List<Hero>) request.getAttribute("heroList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hero list</title>
</head>
<body>
<div>
	<%
		for(Hero hero : heroes) {
		  //out.println("<div><a class=\"entry\" href=\"http://localhost:8080/fs-weblayer/Menu?name=" + menu.getMenuName() + "\">" + menu.getMenuName() + "</a></div>");
			out.println(String.format("<a href=\"herodetails?name=%s\">%s</a><br/>", hero.getName(), hero.getName()));
		}
	%>
</div>
</body>
</html>