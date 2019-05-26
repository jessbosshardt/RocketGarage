$(document).ready(function(){
	
	if($("#hasOpinion").text() == "true"){
		
		$("#like").hide();
		$("#dislike").hide();
		$("#flag").hide();
		
		
	}
	
	
	
	$("#like").click(function(){
		$("#like").fadeOut("slow");
		$("#dislike").fadeOut("slow");
		$("#flag").fadeOut("slow");
		
		 $.ajax({
             type: 'post',
             url: 'like',
             data: { 
            	 'id': $("#id").text()
             },
             success: function (response) {
             	
				$("#likes").text(parseInt($("#likes").text())+1);
				console.log("yay");
             	
             },
             error: function (response) {

             	console.log("nay");
             	
             }
    
          }); 
	});
	
	
	
	
	$("#submit").click(function(){
		
		console.log($("#the-comment").val());		
		
		 $.ajax({
             type: 'post',
             url: 'comment',
             data: { 
            	 'id': $("#id").text(),
            	 'comment': $("#the-comment").val()
             },
             success: function (response) {
             	
            	 
            	 
            	 $(".rocket-comments").prepend("<div class=\"comment\"><div class=\"comment-body\">"+ $("#the-comment").val() +"</div><div class =\"comment-header\">"+$("#username").text()+"</div></div>");
				
				console.log("yay");
             	
             },
             error: function (response) {

             	console.log("nay");
             	
             }
    
          });  
	});
	
	
	
	
	
	$("#dislike").click(function(){
		$("#like").fadeOut("slow");
		$("#dislike").fadeOut("slow");
		$("#flag").fadeOut("slow");
		
		 $.ajax({
             type: 'post',
             url: 'dislike',
             data: { 
            	 'id': $("#id").text()
             },
             success: function (response) {
             	
				$("#dislikes").text(parseInt($("#dislikes").text())+1);
				console.log("yay");
             	
             },
             error: function (response) {

             	console.log("nay");
             	
             }
    
          }); 
	});
	
	
	$("#flag").click(function(){
		$("#like").fadeOut("slow");
		$("#dislike").fadeOut("slow");
		$("#flag").fadeOut("slow");
		
		 $.ajax({
             type: 'post',
             url: 'flag',
             data: { 
            	 'id': $("#id").text()
             },
             success: function (response) {
             	
				alert("Rocket Flagged");
             	
             },
             error: function (response) {

             	console.log("nay");
             	
             }
    
          }); 
	});
	
	
	$("#dislike").click(function(){
		$("#like").fadeOut("slow");
		$("#dislike").fadeOut("slow");
		$("#flag").fadeOut("slow");
	});
	
	$("#flag").click(function(){
		$("#like").fadeOut("slow");
		$("#dislike").fadeOut("slow");
		$("#flag").fadeOut("slow");
	});
	
    
	
	
});