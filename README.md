# MochiJumpLevelEditor

Current Status:

Single HTML/JS Page with working "paint" like program

Spring (Java) built application to host the webpage and transfer data to and from MySQL:

The backend is communicating effectively with the client and the MySQL server both ways.

The last step is to tie it to the MochiJump app

To Do:

Rewrite the JS for the clientside levelEditor so that the corresponding buttons have meaning:

	Start with Import Level button (test with TestTheTable)

Test whether removing jackson api specific code will work and if it can be replaced with:
	public @ResponseBody void RecieverTest(@RequestBody UserInput i)

Decide whether or not MochiJump app will use this app as a controller for importing levels or if it will talk to MySQL server directly

Looking at cloud hosting this project in the future, a NoSQL Database connection may be required to keep cost down.

Note to Future Me:

If this turns into something other than a single page app use Thymeleaf.
