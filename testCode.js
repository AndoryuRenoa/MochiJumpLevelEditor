//below code does not work because of js syntax... adding () after the function makes function not readable...



var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
    var x;
    var y;
    var mouseDown;
    var makeRect;
    var xmlns = "http://www.w3.org/2000/svg";
   
document.getElementById("paintBox").addEventListener("mousemove",function(event){
		cordsFunction(event);
	});
document.getElementById("paintBox").addEventListener("mousedown", mouseDOWN());
document.getElementById("paintBox").addEventListener("mouseup", mouseUp());
document.getElementById("paintBox").addEventListener("mousemove", function(event){
		startDrawBox(event);
	});
	function startDrawBox(downClick){
     if (mouseDown == true){
		startRectX = downClick.clientX-12;
		startRectY = downClick.clientY-12;
        var newRect = document.createElementNS('http://www.w3.org/2000/svg', 'rect');
        newRect.setAttribute("x", startRectX);
        newRect.setAttribute("y", startRectY);
        newRect.setAttribute ("width", 5);
        newRect.setAttribute ("height", 5);
        newRect.setAttribute("fill", "#ffcc66");
        svg.appendChild(newRect);
        document.getElementById("paintBox").appendChild(svg);
      }
     }
        function mouseUp(){
        mouseDown = false;
        }

        function mouseDOWN(){
        mouseDown = true;
        }
	function cordsFunction(e){
		x = e.clientX;
		y = e.clientY;
		var output = "Coordinates : (" + x + "," + y +")";
		document.getElementById("demoOutput").innerHTML = output;
	}
