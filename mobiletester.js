/**
 * extends
 * JavaScript Client Detection
 * (C) viazenetti GmbH (Christian Ludwig)
 */
(function (window) {

        var nVer = navigator.appVersion;
   
        // mobile version
        var mobile = /Mobile|mini|Fennec|Android|iP(ad|od|hone)/.test(nVer);
window.jscd = {
        mobile: mobile,
    };
}(this));
if (jscd.mobile == true){
	alert("This web app is not designed for mobile. Please "+
  "view on a desktop browser. Plans are in the works for "+
  "mobile accessability");
  }
if (jscd.mobile == false){
	console.log ("thanks for viewing this on a desktop/latop!");
}
