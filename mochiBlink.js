// was having issues with html/css layouts calling functions outside of when expected I think it is corrected now with proper css layout

	let counter = 0;
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
		var x = e.clientX;
		var y = e.clientY;
		var output = "Coordinates : (" + x + "," + y +")";
		document.getElementById("demoOutput").innerHTML = output;
	}
