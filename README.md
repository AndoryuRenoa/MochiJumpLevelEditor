# MochiJumpLevelEditor

Current Status: MJLE-0.2.4

hosted via google cloud @ http://mochijump.com/

Email App Created. It is currently a seperate app from the main one. Considering combining them...

Next up:

Create logging file for LevelEditor APP and wait for issue that causes APP to shut down after a week of continuous running:

logging.level.org.springframework.web = DEBUG
logging.level.org.hibernate = ERROR
logging.file = /{$Directory}/Logging.log

I need to change the client to import levels individually, the returnAll api causes a significant increase in CPU usage at this point. This needs to be implemented here in controller and repository classes. I must've removed that prior to last commit.

Should do:

add arrows to move view point in level editor

Change alerts & url for level editor

Notes:

Unexpected shutdowns occur. Updated it to fix possible failure as a result of MySQL connection. Monitored it to observe RAM ussage, no problem there.
