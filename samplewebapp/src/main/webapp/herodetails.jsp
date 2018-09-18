<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="hu.adakiss.sample.dalmock.Hero" %>
<% Hero detailedHero = (Hero) request.getAttribute("detailedHero"); %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Hero details</title>
</head>
<body>
	<div>
		Hero name:<%= detailedHero.getName() %><br/>
		Hero description:<%= detailedHero.getDescription() %><br/>
		First race:<%= detailedHero.getRace1().getName() %> - <%= detailedHero.getRace1Percentage() %>%<br/>
		Second race:<%= detailedHero.getRace2().getName() %> - <%= 100-detailedHero.getRace1Percentage() %>%<br/>
		Owner:<%= detailedHero.getOwner().getUsername() %><br/>
	</div>
</body>
</html>