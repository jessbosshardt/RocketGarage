            function leftArrowPressed() {
            var element = document.getElementById("image1");
            element.style.left = parseInt(element.style.left) - 5 + 'px';
            }

            function rightArrowPressed() {
            var element = document.getElementById("image1");
            element.style.left = parseInt(element.style.left) + 5 + 'px';

            }

            function upArrowPressed() {
            var element = document.getElementById("image1");
            element.style.top = parseInt(element.style.top) - 5 + 'px';
            }

            function downArrowPressed() {
            var element = document.getElementById("image1");
            element.style.top = parseInt(element.style.top) + 5 + 'px';
            }

            function moveSelection(evt) {
                switch (evt.keyCode) {
                    case 37:
                    leftArrowPressed();
                    break;
                    case 39:
                    rightArrowPressed();
                    break;
                    case 38:
                    upArrowPressed();
                    break;
                    case 40:
                    downArrowPressed();
                    break;
                    }
                };

        function docReady()
        {
          
          window.addEventListener('keydown', moveSelection);
        } 




$(document).ready(function(){
	
	window.addEventListener('keydown', moveSelection);
	
$(function(){
        var x = 0;
        setInterval(function(){
            x-=1;
            $('body').css('background-position', x + 'px 0');
        }, 10);
    });


});