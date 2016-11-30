$(function (){

			var $chickens = $('#chickens');
			var $chickenName = $('#chickenName');
			var $eggQty = $('#eggQty');

			var chicken = { 
					chickenName : $chickenName.val(),
					eggQty: $eggQty.val(),
				};
			
			$.ajax({
	
					type: 'GET',
					url: 'FarmAjax/chickens',
					data: chicken,
					success : function (chickens){
						$.each(chickens, function(i, addChicken){
							 $chickens.append('<tr data-id="'+addChicken.id+'"><td>'+ addChicken.chickenName+'<td class="asd">'+addChicken.eggQty+'<td><button data-id="'+addChicken.id+'"class="remove">X</button> <button data-id="'+addChicken.id+'"class="addEgg">+</button><td><tr>');
						});

					},
					error:function(){
						
						alert('Error');
					}
					
			});
			
// Esconder y msotrar el formulario para agregar chicken con el boton "New Chicken" de id="addNewChicken" 
		
       $('#formDiv').hide();
       
			$('#addNewChicken').on('click', function(e){
				
				e.preventDefault();
					$('#formDiv').show();	
					
			});
					
				$('#addChicken').on('click', function(){
					
					var chicken = { 
							chickenName : $chickenName.val(),
							eggQty: $eggQty.val(),
						};
					
				$.ajax({
				
					type:'POST',
					url: '/FarmAjax/add/chickens',
					data: chicken,
						success: function(addChicken){
							 $chickens.append('<tr data-id="'+addChicken.id+'"><td>'+ addChicken.chickenName+'<td class="asd">'+addChicken.eggQty+'<td><button data-id="'+addChicken.id+'"class="remove">X</button> <button data-id="'+addChicken.id+'"class="addEgg">+</button><td><tr>');
						},
						error: function(){
							console.log('Error saving a new chicken. Please try again later');
						}
					});
				});  
			
			$chickens.delegate('.addEgg', 'click', function(){
				
				var $tr = $(this).closest('tr');
				
				var chicken = { 
						chickenName : $chickenName.val(),
						eggQty: $eggQty.val(),
					};	
				
				$.ajax({
					type:'POST',
					url: '/FarmAjax/addEgg/'+$(this).attr("data-id"),
					data: chicken,
					success: function(chicken){
						$tr.find('td.asd').html(chicken.eggQty);
					},
					error : function(){
						alert("addEgg no funciona.");					
					}
				})
			});
			
			$chickens.delegate('.remove','click', function(){

				var $tr = $(this).closest('tr');
				
				$.ajax({
					type: 'DELETE',
					url: '/FarmAjax/remove/'+$(this).attr("data-id"),
					success: function(){
						$tr.fadeOut(300, function(){
							$tr.remove();
						});

						},
					error: function(){
						alert("Error trying to delete. Please try again later");
					}
				});
			});
			
}); 