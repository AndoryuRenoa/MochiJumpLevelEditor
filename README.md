# MochiJumpLevelEditor

Current Status:

Single HTML/JS Page with working "paint" like program

Spring (Java) built application to host the webpage and transfer data to and from MySQL (Incomplete):

Changed JSON Output. example:

{"levelName":"test","xstart":[184.5,360.5,209.5,264.5],"ystart":[97.5,158.5,214.5,110.5],"width":[5,5,5,5],"height":[5,5,5,5]}

Okay I can create an instance of the class I want with Jackson's Object Mapper. I'm still unable to do it as a parameter of an @ResponseBody using boot. Currently the UserInputController class is a mess it needs to be cleaned up, however, at least I'm on the right path. 


Note to Future Me:

If this turns into something outside of a single page app use Thymeleaf.
