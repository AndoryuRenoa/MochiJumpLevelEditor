// was having issues with html/css layouts calling functions outside of when expected I think it is corrected now with proper css layout
// the DOM and event handling seems to be very tricky with JS. onmouseleave seems to fire instantly for some reason for example.	

	var counter = 0;
	var x;
	var y;
	var drawOutput;
	function x(){
		var id = setInterval (frame, 1000);
		function frame(){
			if (counter == 50){
				clearInterval(id);
			}
			else if (counter%2 == 0){
				document.getElementById("blink").src ="https://github.com/AndoryuRenoa/MochiJump/blob/master/blink.png?raw=true";
				counter++;
			}
			else{
				document.getElementById("blink").src ="https://github.com/AndoryuRenoa/MochiJump/blob/master/background.png?raw=true";
				counter++;
			}
		}
	}
	document.getElementById("paintBox").addEventListener("mousemove",function(event){
		cordsFunction(event);
	});
	
	function cordsFunction(e){
		x = e.clientX;
		y = e.clientY;
		var output = "Coordinates : (" + x + "," + y +")";
		document.getElementById("demoOutput").innerHTML = output;
	}
	
	document.getElementById("paintBox").addEventListener("onmousedown",function(event){
		captureStart(event);
		draw();
	});
	function captureStart(e2);{
		var xStart = e2.clientX;
		var yStart = e2.clientY;
	});
	
	function draw(){
		// I think the solution here is to actually use SVG components	
	}
