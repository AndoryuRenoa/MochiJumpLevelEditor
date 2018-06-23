/* place this 
* in the maincontroler class
*/

	@RequestMapping("/")
	public String drawPageLaunch() {
		return"draw.html";
	}
/*
* remember you'll need to fix the js xlmhttprequests to match the new pathing
*/
