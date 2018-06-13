# MochiJumpLevelEditor

Current Status:

Single HTML/JS Page with working "paint" like program

Spring (Java) built application to host the webpage and transfer data to and from MySQL (Incomplete):

Changed JSON Output. example:

{"levelName":"test","xstart":[184.5,360.5,209.5,264.5],"ystart":[97.5,158.5,214.5,110.5],"width":[5,5,5,5],"height":[5,5,5,5]}

Okay I can create an instance of the class I want with Jackson's Object Mapper. I'm still unable to do it as a parameter of an @ResponseBody using Spring Boot without calling the Jackson API independently. Currently the UserInputController class is a mess it needs to be cleaned up, however, at least I'm on the right path. 

To Do:

Today: write UserInput.setLevelName() to include println this.levelName;

Drop and recreate MySQL table to have proper columns

Test/fix new UserInput class for populating said MySQL table

Create levelName drop and repopulate (overwrite) feature with user notification/approval client side

Decide whether or not MochiJump app will use this app as a controller for importing levels or if it will talk to MySQL server directly

Note to Future Me:

If this turns into something other than a single page app use Thymeleaf.
