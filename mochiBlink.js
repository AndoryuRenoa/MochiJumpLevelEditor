// I want to figure out how to end a function with another function within JS I think the answer lies here:
// https://stackoverflow.com/questions/18137656/how-to-stop-a-javascript-function-from-within-another-function

// okay it seems that function y is called when you exit the container containing the image but it seems to be called repatitively
// which is bizzare.

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
	function y(){
		alert("function y() is being called");
}
