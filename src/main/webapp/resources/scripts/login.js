function drawCircle(selector, center, radius, angle, x, y, rotate) {
      var total = $(selector).length;
      var alpha = Math.PI * 2 / total;
      angle *= Math.PI / 180;
           
      $(selector).each(function(index) {
        var theta = alpha * index;
        var pointx  =  Math.floor(Math.cos( theta + angle) * radius);
        var pointy  = Math.floor(Math.sin( theta + angle) * radius );
	
        $(this).css('margin-left', pointx + x + 'px');
        $(this).css('margin-top', pointy + y + 'px');
        $(this).css('transform', 'rotate('+rotate+'deg)');
        
    });
   }

function moveRocket(angle, rotate){
    drawCircle('#rocket', 0, 320, angle, -85, 220, rotate);
    setTimeout(function(){moveRocket(angle+.4, rotate + .40)}, 10);
}



$(document).ready(function(){
	
	$(function(){
        var x = 0;
        setInterval(function(){
            x-=.2;
            $('body').css('background-position', x + 'px 0');
        }, 10);
    });
	
	
	$("button[name = 'register']").click(function(){
		$("#login-div").slideToggle();
		$("#register-div").slideToggle();
		$("#rocket").fadeOut('slow');
	});
	
	$("button[name = 'cancel-register']").click(function(){
		$("#login-div").slideToggle();
		$("#register-div").slideToggle();
		$("#rocket").fadeIn('slow');
	});
	
	var angle = 90;
	var rotate = -120;
	moveRocket(angle, rotate);
    
	
});

