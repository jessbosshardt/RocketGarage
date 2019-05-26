$(document).ready(function(){
	
	
	$(".flex-item").click(function(){
		$("#f-layout").val($(this).find(".id").val());
		if($(this).hasClass('selected')){  
			$(this).removeClass('selected');
			$("#view-s").fadeOut('slow');
			$("#send").fadeOut('slow');
		} else {
			$("#view-s").fadeIn('slow');
			$("#send").fadeIn('slow');
			$(this).addClass('selected').siblings().removeClass('selected');    
		}
	});
	
	$("#view-s").click(function(){
		$("#go").attr("action","sendtoView");
		$("#go").submit();
	});
	
	$("#send").click(function(){
		$.ajax({
            type: 'post',
            url: 'sendtoGarage',
            data: { 
              'id' : $("#f-layout").val(),
            },
            success: function (response) {
            	
			alert("Rocket added to garage!");		
            	
            },
            error: function (response) {

            	console.log("nay");
            	
            }
            
            
         }); 
	});
	
    
	
});