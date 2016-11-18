$(function(){
 	var $chickens= $('#chickens');
 	var $eggs= $('#eggs');


 	var $chickenName = $('#chickenName');
 	var $eggList = $('#eggList');

 	var $colour = $('#colour');
 	var $chickenId = $('#chickenId');

 	var chickenTemplate = ""+
 	"<li data-id='{{id}}'>" +
 	"<p><strong>Name:</strong>{{chickenName}}</p>" +
	"<p><strong>Eggs:</strong>{{eggList}}</p>" +
	"<button data-id='{{id}}' class='remove'>X</button>" +
	"<li>";
 	
 	function addEgg(chicken){
 		$chickens.append(Mustache.render(chickenTemplate,chicken));
 	}

	$.ajax({
		type:'GET', 
		url:'/FarmAjax/chickens/'+ farmId,
		success: function(chickens){
			$.each(chickens, function(i, chicken){
			  $chickens.append('<li> Name: ' +chicken.chickenName+' - Eggs: '+chicken.eggList+' '+'<button data-id='+chicken.id+' class="remove">Delete</button></li>');
			});
		},
		error: function(){
			alert(farmId);
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
			$chickens.append('<li> Chicken:' +addEgg.chickenName+' Eggs: '+addEgg.eggList+'</li>'+'<button data-id='+chicken.id+' class="remove">Delete</button></li>'); 
				},
			error: function(){
				alert('Error saving a new egg. Please try again');
			}
		});
	});
	
	$chickens.delegate('.remove','click', function(){

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
	})
});