$(document).ready(function(){
	
	
	$(".flex-item").click(function(){
		
		$("#f-layout").val($(this).find(".id").val());
		
		
		$("#levels").hide();
		if($(this).hasClass('selected')){  
			$(this).removeClass('selected');
			$("#build").hide();
			$("#view").hide();
			$("#share").hide();
			$("#destroy").hide();
			$("#launch").hide();
			$("#new-rocket").fadeIn('slow');
		} else {
			$("#launch").fadeIn('slow');
			$("#view").fadeIn('slow');
			$("#share").fadeIn('slow');
			$("#build").fadeIn('slow');
			$("#destroy").fadeIn('slow');
			$("#new-rocket").hide();
			$(this).addClass('selected').siblings().removeClass('selected');    
		}
	});
	
	$("#new-rocket").click(function(){
		$(".selected").removeClass('selected');
		$("#levels").fadeIn('slow');
		$("#destroy").hide();
		$("#build").hide();
		$("#launch").hide();
		$("#view").hide();
		$("#share").hide();
	});
	
	
	$("#build").click(function(){
		$("#go").attr("action","rocket");
		$("#go").submit();

	});
	
	$("#share").click(function(){
		console.log("in function")
		$.ajax({
			type : 'post',
			url : 'share',
			data:{
				'id' : $("#f-layout").val()
				
			},
			success : function(response)
			{
				alert("Rocket Shared!");
			},
			error: function(response)
			{
				alert("Sorry Rocket Wasnt able to be Shared");
			}
			
			
		})
		
		
	});
	$("#easy").click(function(){
		$("#go").attr("action","newrocket");
		$("#f-layout").val(1);
		$("#go").submit();
	});
    
	$("#medium").click(function(){
		$("#go").attr("action","newrocket");
		$("#f-layout").val(2);
		$("#go").submit();
	});
	
	$("#hard").click(function(){
		$("#go").attr("action","newrocket");
		$("#f-layout").val(3);
		$("#go").submit();
	});
	
	$("#view").click(function(){
		$("#go").attr("action","sendtoView");
		$("#go").submit();
	});
	
	$("#launch").click(function(){
		$("#go").attr("action","fly");
		$("#go").submit();
	});
	
	$("#destroy").click(function(){
		
		remove = $(".selected");
		
		$.ajax({
            type: 'post',
            url: 'removeRocket',
            data: { 
              'id' : $("#f-layout").val()
            },
            success: function (response) {
            	
			remove.remove();
			$("#build").hide();
			$("#view").hide();
			$("#share").hide();
			$("#destroy").hide();
			$("#new-rocket").fadeIn('slow');
			
            	
            },
            error: function (response) {

            	console.log("nay");
            	
            }
            
            
         }); 
			
	});
	
	
});
