<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<style>
body{
	margin-left:30px;
}
</style>
<head>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		
<title>jQuery Ajax Tutorial</title>
</head>	
<body>
		<h1>Welcome!</h1>
<br>
		<div class="page-header">
			<h3>Farm: Uncle Eddys farm</h3>
		</div>
		<br>
		<ul id="chickens"></ul>
		<br>
		<div> 
			<%-- <a  href="<%=request.getContextPath()%>/Eggs/Add/">Add a new egg</a> --%>
		</div> 
		
		
	
		
<%---------------------            [  main.js  ]              archivo Javascript      ------------------------%>
		
		
<script type="text/javascript">
		
		$(function(){
			
		 	var $chickens= $('#chickens');
		 	
		 		$.ajax({
				type:'GET',
				url:'/FarmAjax/view/chickens',
				success: function(chickens){
					$.each(chickens, function(i, chicken){
					  $chickens.append('<li>Name: ' +chicken.chickenName+' - Eggs:  '+'<button data-id='+chicken.id+' class="remove">Delete</button></li>');
					});
				},
				error: function(){
					alert("I'm sorry, there it was a problem trying to load the chicken list, or is empty");
				}
			});

			$('#addEgg').on('click', function(){

				var chicken = {
					chickenName: $chickenName.val(),
					eggList: $eggList.val(),
				};

				var egg = {
					colour: $colour.val(),
					chickenId: $chickenId.val(),
				};

				$.ajax({
					type:'POST',
					url: '/FarmAjax/add',
					data: hero,
						success: function(addEgg){
					$chickens.append('<li> Chicken:' +addEgg.chickenName+' Eggs: '+addEgg.eggList+'</li>'+'<button data-id='+addEgg.id+' class="remove">Delete</button></li>'); 
						},
					error: function(){
						alert('Error saving a new egg. Please try again');
					}
				});
			});
			
		/* 	$chickens.delegate('.remove','click', function(){

				var $li = $(this).closest('li');
				$.ajax({
					type: 'DELETE',
					url: '/FarmAjax/remove/'+$(this).attr("data-id"),
					success: function(){
						$li.fadeOut(300, function(){
							$li.remove();
						})
					}
				})
			}) */
		});
		</script>
</body>
</html>