// I need to create an arraylist to house all the data that I'm holding for these rectangles
// the data inside the arraylist will be what is sent to the database and then ultimately to mochiJump.


//actually something like the below will work well for now. I just need some radio buttons for the size selection... 
//for whatever reason svg needs to be told to be 100% of the height and width of the container and syntax is very important
//when doing this.

	var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
    svg.setAttribute ("width", "100%");
    svg.setAttribute ("height", "100%");
    var x;
	var y;
    var mouseDown;
    var makeRect;
    var xmlns = "http://www.w3.org/2000/svg";
   
document.getElementById("paintBox").addEventListener("mousemove",function(event){
		cordsFunction(event);
	});
document.getElementById("paintBox").addEventListener("mousedown", mouseDn);
document.getElementById("paintBox").addEventListener("mouseup", mouseUp);
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
	function cordsFunction(e){
		x = e.clientX;
		y = e.clientY;
		var output = "Coordinates : (" + x + "," + y +")";
		document.getElementById("demoOutput").innerHTML = output;
	}
    function mouseDn(){
    	mouseDown= true;
        }
    function mouseUp(){
    	mouseDown= false;
        }
