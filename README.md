# MochiJumpLevelEditor

*Replacing the currently statically served front end with an angular project! Changing the Spring Apps to back end work only, while I work on the new front end this repository will not likely be updated*

For combining the front and back-end: https://techshard.com/2018/08/12/building-a-web-app-using-spring-boot-angular-6-and-maven/

Current Status: MJLE-0.2.4

multiple services, including google cloud & AWS entry point is: http://mochijump.com/

Notes:

The website/level editor running on GCE is killed by the OS due to out of memory error. Attempt to reduce memory usage:
https://stackoverflow.com/questions/38747525/spring-cloud-microservices-memory-usage


Next up:

*fix typo in modal div*

Create user/password functionality

At the very least warn users the app isn't optimized for mobile. See mobiletester.js

Should do:

need to change the client to import levels individually, the returnAll api causes a significant increase in CPU usage at this point. This needs to be implemented here in controller and repository classes. I must've removed that prior to last commit.

add arrows to move view point in level editor

Change alerts & url for level editor

Want to do:

I kind of want to setup mail server for MochiJump using Apache-James
