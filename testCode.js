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
    var xhttp = new XMLHttpRequest();
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
		// this needs to be reworked to actually delete everything in the svg "i = 0, while i<.length, i++" type of situation
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
// fix the format below, don't know how it lost it's indendation
// IMPORTANT implement htmlspecialchars in the forms below in order to keep page safe/secure
// see: https://www.w3schools.com/php/php_form_validation.asp
function callLevel(){
    var levelName = document.getElementsByID("levelName");
    // create xmlrequest to send levelName to "RetrieveLevel.php";
    xhttp.onreadystatechange = function(){
	    if (this.readyState == 4 && this.status ==200){
		    alert ("connections successful"); // I need to think of what I want to put here
		    // okay the input I receive from this will be this.reponseText; Possibly a JSON object that will need to be worked
		    // into the paint box, I should create a more functional clearAll() that I can call as the first line of this inner
		    // function
    		}
    };
	xhttp.open("POST", "RetrieveLevel.php?q=", true); // maybe I can use different t=,q= to send the table name outside of the array?
	xhttp.send(levelName);
    alert("Feature currently being tested");

}
function createNewLevel(){
    var levelName = document.getElementsByID("levelName");
    // create xmlrequest to send levelName to "CreateTable.php";
    xhttp.onreadystatechange = function(){
	    if (this.readyState == 4 && this.status == 200{
		alert ("connection success");
	    // In this instance I just need to be sure that the table's name is saved correctly and not already taken
		alert ("This feature is not yet implimented");
	}
     };
	xhttp.open("POST", "TableMaker.php?q=", true);
	xhttp.send(levelName);
	alert ("Feature currently being tested");
}
function submitLevel(){
	allRects = svg.getElementsByTagName("*");
	var JSONRects = JSON.stringify(allRects);
	xhttp.onreadystatechange = function(){
		if (tis.readyState == 4 && this.staus ==200){
			alert ("connection successful");
		}
	};
	xhttp.open("POST", "SaveLevel.php?q=", true);
	// this needs to be tested (also I'm currently not using .setRequestHeader, don't think I need it as long as the PHP code takes
	// that into account?)
	// this also needs to include the name of the Table! Maybe this can be done via PHP?
	xhttp.send(JSONRects);
}	
