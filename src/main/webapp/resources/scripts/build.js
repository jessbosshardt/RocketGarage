gridLevel = 0;
gridSize = 0;
function initGrid(level){
	console.log(level);
	
	switch(level){
	case "1":
		gridSize = 64;
		createGrid();
		console.log("inside");
		$('.tile').css("width", "58px");
		$('.tile').css("height", "58px");
		
		
		$('#palet').children().each(function () {
			$(this).css("width", "60px");
			$(this).css("height", "60px");
		});
		
	
		
		break;
		
	case "2":
		gridSize = 256;
		createGrid();
		
		$('.tile').css("width", "29px");
		$('.tile').css("height", "29px");

		$('#palet').children().each(function () {
			$(this).css("width", "30px");
			$(this).css("height", "30px");
		});
		
	
		break;
	
	
	case "3":	
		gridSize = 1024;
		createGrid();
		
		$('.tile').css("width", "14.5px");
		$('.tile').css("height", "14.5px");

		$('#palet').children().each(function () {
			$(this).css("width", "15px");
			$(this).css("height", "15px");
		});
		
		
		
		
		break;
			
	}
	
	
}

 function getRandomInt(min, max) {
	    return Math.floor(Math.random() * (max - min + 1)) + min;
	}
 
 
 
 function dataURItoBlob(dataURI) {
	    var binary = atob(dataURI.split(',')[1]);
	    var array = [];
	    for(var i = 0; i < binary.length; i++) {
	        array.push(binary.charCodeAt(i));
	    }
	    return new Blob([new Uint8Array(array)], {type: 'image/jpeg'});
	}
 

i = 0;
function allowDrop(ev) {
	ev.preventDefault();
}

function drag(ev) {
	ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
	ev.preventDefault();
	var data = ev.dataTransfer.getData("text");

	if (ev.ctrlKey) {
		
		ev.target.appendChild(document.getElementById(data));
	} else {
		var nodeCopy = document.getElementById(data).cloneNode(true);
		nodeCopy.id = "newId" + i;
		ev.target.appendChild(nodeCopy);
		i++;
		

	}

}


function saveGridContents(){
	
	let gridArray = [];
	$(".tile").each(function(i,obj){
		gridArray.push($(this).get(0).innerHTML);
	});
	
	gridArray.unshift(gridLevel);
	t =gridArray.toString();
	console.log(t);
	return t;
	
}

function rebuildRocket(rocketString){
	
	let rebuildGrid = rocketString.split(",");
	initGrid(rebuildGrid[0]);
	$(".tile").each(function(i,obj){
		$(this).append(rebuildGrid[i+1]);
	})
	
}



function createGrid() {
	for (var i = 0; i < gridSize; i++) {
		$('#grid').append('<div id="div'+ i + '" ondrop="drop(event)" ondragover="allowDrop(event)" class="tile"</div>');
	}
};

$(document).ready(function(){

	gridLevel=$("#level").html();
	
	console.log(gridLevel);
	
	initGrid(gridLevel);
	
	if(gridLevel ==0)
		rebuildRocket($("#layout").html());
	
	var palet = $("#palet");
	
	$('#palet').children().each(function () {
		this.addEventListener("dragstart", function(e) {
		    var crt = this.cloneNode(true);
		    crt.style.display = "none"; /* or visibility: hidden, or any of the above */
		}, false);
	});
	
	
	$("#back").click(function(){
		
		
	});
	
	
	$(document).keyup(function(e){
		var img = $(".active").find('img');
		if(e.which==46)
			{
				img.first().remove();
			}
	})

	$('.tile').click(function() {
		var img = $(this).find('img');
		if (img.hasClass('north')) {
			img.attr('class', 'west');
		} else if (img.hasClass('west')) {
			img.attr('class', 'south');
		} else if (img.hasClass('south')) {
			img.attr('class', 'east');
		} else if (img.hasClass('east')) {
			img.attr('class', 'north');
		}
	});

	
	$('input').click(function() {
		var img = $('.active img');
		if (img.hasClass('north')) {
			img.attr('class', 'west');
		} else if (img.hasClass('west')) {
			img.attr('class', 'south');
		} else if (img.hasClass('south')) {
			img.attr('class', 'east');
		} else if (img.hasClass('east')) {
			img.attr('class', 'north');
		}
	});

	$(".tile").click(function() {
		if ($(this).hasClass('active')) {
			$(this).removeClass('active');
		} else {
			$(this).addClass('active').siblings().removeClass('active');
		}
	});	
	
	$("#downSub").click(function(){
		
		
		html2canvas($("#grid"), {
	            onrendered: function(canvas) {
	                theCanvas = canvas; 
					canvas.toBlob(function(blob) {
					    saveAs(blob, $("#downName").val());
					});
	            },
			});
			
		});
	
	
	
    $("#saveSub").click(function() { 
    	
    	$(".active").removeClass('active');
    	
    	$("#grid").css("border", "none");
    	
        html2canvas($("#grid"), {
            onrendered: function(canvas) {
                theCanvas = canvas;            
                var dataUrl = canvas.toDataURL("image/png");
                var key = getRandomInt(0, Number.MAX_SAFE_INTEGER).toString();
                var imgdata = dataUrl.replace(/^data:image\/(png|jpg);base64,/, "");
                var gridData = saveGridContents();
                var name = $('#Rname').val();
                console.log(name);
                
                $.ajax({
                    type: 'post',
                    url: 'save',
                    data: { 
                      'key' : key,
                      'image': imgdata,
                      'grid' : gridData,
                      'name' : name,
                      'userId' : 1
                    },
                    success: function (response) {            
                    alert("Rocket successfully saved!")
    				console.log("yay");
                    
                    },
                    error: function (response) {

                    	console.log("nay");
                    	
                    }
                    
                    
                 }); 
                
                
                
            }
        }); 
    }); 
    
});
