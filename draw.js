// okay I can now manipulate the svg component on the webpage to draw what I need. Next step is to finish the function mousedown
// to mouse up. I also need to create an arraylist to house all the data that I'm holding for these rectangles
// the data inside the arraylist will be what is sent to the database and then ultimately to mochiJump.


  var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
	var x;
	var y;
    var mouseDown;
    var makeRect;
    var xmlns = "http://www.w3.org/2000/svg";
   document.getElementById("paintBox").addEventListener("mousemove",function(event){
		cordsFunction(event);
	});
	
	function cordsFunction(e){
		x = e.clientX;
		y = e.clientY;
		var output = "Coordinates : (" + x + "," + y +")";
		document.getElementById("demoOutput").innerHTML = output;
	}
document.getElementById("paintBox").addEventListener("click", function(event){
		startDrawBox(event);
	});
	function startDrawBox(downClick){
		startRectX = downClick.clientX-13;
		startRectY = downClick.clientY-11;
        var newRect = document.createElementNS('http://www.w3.org/2000/svg', 'rect');
        newRect.setAttribute("x", startRectX);
        newRect.setAttribute("y", startRectY);
        newRect.setAttribute("width", 50);
        newRect.setAttribute("height", 50);
        newRect.setAttribute("fill", "#ffcc66");
        svg.appendChild(newRect);
        document.getElementById("paintBox").appendChild(svg);
      }



