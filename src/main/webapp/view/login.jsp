<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
		
	<a href="http://localhost:8080/FarmAjax/?language=en">English</a><span> | </span><a href="http://localhost:8080/FarmAjax/?language=es">Español</a>
		
		<div class="page-header">
		<h2><spring:message code="welcomelogin.caption"/></h2>
	</div>
		<form id="login">
			Username: <input type="text" name="username" value="">
			Password: <input type="password" name="password" value="">
		</form>
		
</body>
</html>