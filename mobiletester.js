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
   
alert('Mobile: ' + jscd.mobile + '\n' );
