/** to Do:
* add delete last addition button
* add mochi start point
* add radio buttons for different rectangle sizes
* make sure svg components' characteristics can be exported
*/

/** Notes: code requires arrays to function properly
*/



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

