/** to Do:
* add delete last addition button
* add mochi start point
* make sure svg components' characteristics can be exported
*/

/** Notes: Currently working on a way to output all of the coordinates, heights, and widths for the rects
*getting close to having to learn how to export and work with a database!
*/

var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
    svg.setAttribute ("width", "100%");
    svg.setAttribute ("height", "100%");
    var x;
	var y;
    var mouseDown;
    var makeRect;
    var xmlns = "http://www.w3.org/2000/svg";
	var brushSize = 5;
	var pBRects = document.getElementById("paintBox").getBoundingClientRect();
	document.getElementById("paintBox").style.cursor = "crosshair";
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
		startRectX = downClick.clientX-pBRects.left-5;
		startRectY = downClick.clientY-pBRects.top-5;
        var newRect = document.createElementNS('http://www.w3.org/2000/svg', 'rect');
        newRect.setAttribute("x", (startRectX*2-brushSize)/2);
        newRect.setAttribute("y", (startRectY*2-brushSize)/2);
        newRect.setAttribute ("width", brushSize);
        newRect.setAttribute ("height", brushSize);
        newRect.setAttribute("fill", "#ffcc66");
        svg.appendChild(newRect);
        document.getElementById("paintBox").appendChild(svg);
      }
     }
	function cordsFunction(e){
		x = e.clientX -pBRects.left-5;
		y = e.clientY-pBRects.top-5;
		var output = "Coordinates : (" + x + "," + y +")";
		document.getElementById("demoOutput").innerHTML = output;
	}
    function mouseDn(){
    	mouseDown= true;
        }
    function mouseUp(){
    	mouseDown= false;
        }
	function brushS(){
		brushSize = 5;
	}
	function brushM(){
		brushSize = 50;
	}
	function brushL(){
		brushSize = 150;
	}
	function clearAll(){
		location.reload();
	}
	function getCoords(){
			var allRects = svg.getElementsByTagName("*");
			var testOutput = allRects[0].getBoundingClientRect();
			alert(testOutput.top);
	}	
