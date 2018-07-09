# MochiJumpLevelEditor

Current Status:

Currently hosted via google cloud - Spring App runnable JAR @ http://mochijump.com/

Added landing page

Currently Running MochiJumpLevelEditor2

To Do:

Add MochiJump download option

Add login/security

https://spring.io/guides/gs/securing-web/

https://medium.com/@gustavo.ponce.ch/spring-boot-spring-mvc-spring-security-mysql-a5d8545d837d

https://developers.google.com/identity/

http://automateddeveloper.blogspot.com/2014/03/securing-your-mobile-api-spring-security.html

https://docs.spring.io/spring-security/site/docs/3.0.x/reference/remember-me.html

script port forwarding and server startup on instance startup

http://jasonleveille.com/blog/2013/01/debian-ubuntu-adding-a-startup-script/

https://stackoverflow.com/questions/22712080/how-to-run-java-application-on-startup-of-ubuntu-linux

*I'd like to experiment with WebRTC here in the future, seems like a useful API to know*

	http://builds.kurento.org/release/stable/docs/tutorials/java/tutorial-4-one2one.html

Test whether removing jackson api specific code will work and if it can be replaced with:
	public @ResponseBody void RecieverTest(@RequestBody UserInput i)

New js required for iphone touch control, seems all input counts as x,y position null.

	https://stackoverflow.com/questions/24693447/svg-getintersectionlist-returns-null?noredirect=1&lq=1
	
Take the time to break apart js/css/html once testing is complete

row (levelName) duplicate check and override needs to be built

Look into correcting the offset caused by the header, margins, and position of user's window when creating objects (only visible when retrieving objects) -- I think this is caued by objects having an x and y value of .5 occassionally, when they're retrieve everything is rounded up

Note to Future Me:

https://projects.spring.io/spring-security-oauth/docs/oauth2.html
