# MochiJumpLevelEditor

Current Status:

Currently hosted via google cloud - Spring App runnable JAR @ http://mochijump.com/ (currently the landing page is the level editor)

Build held in this repository causes 404 return error. Rebuilt version works fine. Will take the time to see what is different between the two builds to determine the issue. (Possible solution - POM.XLM ? GroupID?)

Currently Running MochiJumpLevelEditor2 - Fix buttons with correct JS functions attached (current get attributes saves the level).

for some reason changing .ddl-auto=none causes issues on the production server if this is not resolved a restart of the app will cause all saved data to be lost

The last step is to tie it to the MochiJump app

To Do:

Test whether removing jackson api specific code will work and if it can be replaced with:
	public @ResponseBody void RecieverTest(@RequestBody UserInput i)

New js required for iphone touch control, seems all input counts as x,y position 0.

	https://stackoverflow.com/questions/24693447/svg-getintersectionlist-returns-null?noredirect=1&lq=1

row (levelName) duplicate check and override needs to be built

Look into correcting the offset caused by the header, margins, and position of user's window when creating objects (only visible when retrieving objects)

Decide whether or not MochiJump app will use this app as a controller for importing levels or if it will talk to MySQL server directly

Note to Future Me:

If this turns into something other than a single page app use Thymeleaf.
