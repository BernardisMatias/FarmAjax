<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<style>
		#asd {
		width: 600px;
		margin-left: 20px; 
		}
		</style>
<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>



<title>jQuery Ajax Tutorial</title>
</head>
<body>
	<a href="http://localhost:8080/FarmAjax/?language=en">English</a><span> | </span><a href="http://localhost:8080/FarmAjax/?language=es">Español</a>

	<h1><spring:message code="welcome.caption"/></h1>
	<div class="page-header">
		<h3><spring:message code="farmName.caption"/></h3>
	</div>
	<br>
	<div id="asd">
	<table id="chickens" class="table"> 
		<thead> 
				<tr> 
						<th><spring:message code="chicken.caption"/></th> 	
						<th><spring:message code="quantity.caption"/></th> 
						<th><spring:message code="deleteAdd.caption"/></th>
	 			</tr> 
	 	</thead>  
	 </table>
	<br>
	<button id="addNewChicken"><spring:message code="newchicken.caption"/></button>
	<div id="formDiv">
			<spring:message code="newChickenName.caption"/><input type="text" id="chickenName" >
			<button id="addChicken"><spring:message code="saveNewChicken.caption"/></button>
	</div>
	
	<div id="ErrorChickenName" class="hidden" ><spring:message code="errorNewChicken.caption"/></div>
	</div>
	
	<!-- Archivo Javascript -->
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/ajax.js"> </script>
		
</body>
</html>