<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hu.adakiss.sample.common.LoginAttribute" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>

	<div class="error">
	
	</div>
	<% 
		String userName = (String) request.getAttribute(LoginAttribute.ATTR_USERNAME); 
		String errorMessage = (String) request.getAttribute(LoginAttribute.ATTR_ERROR); 
	%>
	<div class="mainContainer">
		<div class="error"><%= errorMessage %></div>
		<form action="registration" method="post">
			Username:<input type="text" name="username"/><br/><%= userName %><br/>  
			Password:<input type="password" name="password"/><br/><br/>  
			<input type="submit" value="Registration"/>
		</form>  
	</div>

</body>
</html>