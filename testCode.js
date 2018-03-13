<!DOCTYPE html>
<html>
<style>
div.paintbox{
	margin: 0px;
	border: 5px solid blue;
	position: relative;
	width: 500px;
	height: 300px;
}
div.words{
	position: relative;	
	left : 50%;
}
</style>
<div class ="words">
</div>
<div class ="paintbox" id="paintBox">
</div>
<p id = "demoOutput">Cords go here</p>
</body>
<script>
// hmmm I wonder why this doesn't work..

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
document.getElementById("paintBox").addEventListener("mousedown", function(event){
		startDrawBox(event);
	});
	function startDrawBox(downClick){
		startRectX = downClick.clientX-13;
		startRectY = downClick.clientY-11;
        var newRect = document.createElementNS('http://www.w3.org/2000/svg', 'rect');
        newRect.setAttribute("x", startRectX);
        newRect.setAttribute("y", startRectY);
        newRect.setAttribute("fill", "#ffcc66");
      }
document.getElementById("paintBox").addEventListener("mouseup", function(event){
		finishDrawBox(event);
        });
        function finishDrawBox(upClick){
        	var finishRectX = upClick.clientX-13;
        	var finishRectY = upClick.clientX-11;
        	newRect.setAttribute("width", finishRectX-startRectX);
        	newRect.setAttribute("height", finishRectY-startRectY);
        	svg.appendChild(newRect);
        	document.getElementById("paintBox").appendChild(svg);
		}
</script>
</html>
