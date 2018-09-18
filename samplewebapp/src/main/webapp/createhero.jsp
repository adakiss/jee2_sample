<%@page import="hu.adakiss.sample.dalmock.Race"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create hero page</title>
</head>
<body>

		<% 
			String errorMessage = (String) request.getAttribute("validationError");
			List<Race> races = (List<Race>) request.getAttribute("races");
		%>

		<div class="error"><%= errorMessage %></div>
		<form action="createhero" method="post">
			Hero name:<input type="text" name="name"/><br/><br/>  
			Description:<input type="text" name="description"/><br/><br/> 
			First race:<select name="race1">
						  <%
						  	for(Race race : races) {
						  	  out.println(String.format("<option value=\"%s\">%s</option>", race.getName(), race.getName()));
						  	}
						  %>
						</select><br/> 
			Second race:<select name="race2">
						  <%
						  	for(Race race : races) {
						  	  out.println(String.format("<option value=\"%s\">%s</option>", race.getName(), race.getName()));
						  	}
						  %>
						</select><br/> 
			First race %: 1 <input type="range" name="race1Percentage" min="1" max="99" step="1"/> 99<br/> 
			<input type="submit" value="Create"/>
		</form>  
</div>
</body>
</html>