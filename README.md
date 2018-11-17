# MochiJumpLevelEditor

## Google Cloud

Lesson learned, regarding changing instance. Always create and run a backup first


## Additional Information

*Replacing the currently statically served front end with an angular project! New repsitory for the combined product!: https://github.com/AndoryuRenoa/MochiJumpWeb-SinglePackageDeployment

Current Status: MJLE-0.2.5

multiple services, including google cloud & AWS entry point is: http://mochijump.com/

## Notes:

Currently working on setting up http/2 reliably. Using Java 8 may need libtcnative directory


## Future Stuff:
The website/level editor running on GCE is killed by the OS due to out of memory error. Attempt to reduce memory usage:
https://stackoverflow.com/questions/38747525/spring-cloud-microservices-memory-usage


Next up:

Create user/password functionality [Done]

create registration by email [Done]

Should do:

need to change the client to import levels individually, the returnAll api causes a significant increase in CPU usage at this point. This needs to be implemented here in controller and repository classes. I must've removed that prior to last commit.

add arrows to move view point in level editor

Change alerts & url for level editor
