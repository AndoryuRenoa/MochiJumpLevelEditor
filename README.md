# MochiJumpLevelEditor

Current Status:

Currently hosted via google cloud - Spring App runnable JAR @ http://mochijump.com/ (currently the landing page is the level editor)

Build held in this repository causes 404 return error. Rebuilt version works fine. Will take the time to see what is different between the two builds to determine the issue. (Possible solution - POM.XLM ? GroupID?)

Currently Running MochiJumpLevelEditor2

Data loss problem solved (.ddl-auto).

The last step is to tie it to the MochiJump app

To Do:

Test whether removing jackson api specific code will work and if it can be replaced with:
	public @ResponseBody void RecieverTest(@RequestBody UserInput i)

New js required for iphone touch control, seems all input counts as x,y position 0.

	https://stackoverflow.com/questions/24693447/svg-getintersectionlist-returns-null?noredirect=1&lq=1

row (levelName) duplicate check and override needs to be built

Look into correcting the offset caused by the header, margins, and position of user's window when creating objects (only visible when retrieving objects)

I'm going to use this as the backend for the main app as well. Further reading:

https://jkutner.github.io/2016/08/18/android-backend-api-heroku-retrofit.html

Note to Future Me:

If this turns into something other than a single page app use Thymeleaf.
