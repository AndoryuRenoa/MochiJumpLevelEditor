	let counter = 0;
	let mouseExit = false;
	function x(){
		if (mouseExit == true){
			return;
		}
		else {
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
}
	function y(){
		mouseExit = true;
		// this doesn't stop function x() either.
}
