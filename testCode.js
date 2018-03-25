// This will house the working code for working with xmlhttprequest and JSON once complete it will move back to draw.js

    var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
    svg.setAttribute ("width", "100%");
    svg.setAttribute ("height", "100%");
    var x;
    var y;
    var mouseDown;
    var makeRect;
    var xmlns = "http://www.w3.org/2000/svg";
    var brushSize = 5;
    var allRects;
    var pBRects = document.getElementById("paintBox").getBoundingClientRect();
document.getElementById("paintBox").style.cursor = "crosshair";
document.getElementById("paintBox").addEventListener("mousemove",function(event){
		cordsFunction(event);
	});
document.getElementById("paintBox").addEventListener("mouseleave", mouseReset);
document.getElementById("paintBox").addEventListener("mousedown", mouseDn);
document.getElementById("paintBox").addEventListener("mouseup", mouseUp);
document.getElementById("paintBox").addEventListener("mousemove", mouseMoveDrawBox);
	function mouseMoveDrawBox(){
     if (mouseDown == true){
		makeNewBox();
      }
     }
	function makeNewBox(){
        var newRect = document.createElementNS('http://www.w3.org/2000/svg', 'rect');
        newRect.setAttribute("x", (x*2-brushSize)/2);
        newRect.setAttribute("y", (y*2-brushSize)/2);
        newRect.setAttribute ("width", brushSize);
        newRect.setAttribute ("height", brushSize);
        newRect.setAttribute("fill", "#82571b");
		//^^ same color as in mochiJump currently
        svg.appendChild(newRect);
        document.getElementById("paintBox").appendChild(svg);
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
		makeNewBox();
        }
	function mouseReset(){
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
			allRects = svg.getElementsByTagName("*");
			var testOutput = allRects[0].getBoundingClientRect();
			alert(allRects.length+" objects have been created. Attributes for the first painted object is: x="+testOutput.left+", y="+ testOutput.top+",width="+testOutput.width+",height="+testOutput.height);
			//^^ I'm so close to being able to export this data to a database!!!
	}
// have not tested the function below! May need line to update document!
	function delLastAdded(){
		svg.removeChild(svg.lastChild);
		svg.removeChild(svg.lastChild);
	}
	
	function callLevel(){
    var levelName = document.getElementsByID("levelName");
    // create xmlrequest to send levelName to "RetrieveLevel.php";
		alert("This feature is not yet implimented");
	}
	function createNewLevel(){
    var levelName = document.getElementsByID("levelName");
    // create xmlrequest to send levelName to "CreateTable.php";
		alert ("This feature is not yet implimented");
	}
