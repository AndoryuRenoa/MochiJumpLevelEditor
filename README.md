# MochiJumpLevelEditor

Current Status:

Currently hosted via google cloud - Spring App runnable JAR @ http://mochijump.com/ (currently the landing page is the level editor)

Added landing page. Not compiled

Currently Running MochiJumpLevelEditor2

To Do:

create pathing for landing.html

tie it to the MochiJump app

Test whether removing jackson api specific code will work and if it can be replaced with:
	public @ResponseBody void RecieverTest(@RequestBody UserInput i)

New js required for iphone touch control, seems all input counts as x,y position null.

Take the time to break apart js/css/html once testing is complete

	https://stackoverflow.com/questions/24693447/svg-getintersectionlist-returns-null?noredirect=1&lq=1

row (levelName) duplicate check and override needs to be built

Look into correcting the offset caused by the header, margins, and position of user's window when creating objects (only visible when retrieving objects)

I'm going to use this as the backend for the main app as well. Further reading:

https://jkutner.github.io/2016/08/18/android-backend-api-heroku-retrofit.html
https://www.twilio.com/docs/voice/tutorials/click-to-call-java-spring

Note to Future Me:

If this turns into something other than a single page app use Thymeleaf.
