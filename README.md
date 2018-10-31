# MochiJumpLevelEditor

## Google Cloud

Attempting to upgrade the instance on Google Compute Engine has temporarily shut down hosting. This is due to gCloud not having enough resources to complete the update, which is disconcerting as it's only an increase of 1 gb.  A workable solution is to create a new instance and change zones, however, this generates a new IP address which requires updating the DNS records. This is a good lesson to learn now. Better to create the replacement first otherwise you risk your site being down for a significant amount of time.

## Additional Information

*Replacing the currently statically served front end with an angular project! New repsitory for the combined product!: https://github.com/AndoryuRenoa/MochiJumpWeb-SinglePackageDeployment

Current Status: MJLE-0.2.4

multiple services, including google cloud & AWS entry point is: http://mochijump.com/

Notes:

The website/level editor running on GCE is killed by the OS due to out of memory error. Attempt to reduce memory usage:
https://stackoverflow.com/questions/38747525/spring-cloud-microservices-memory-usage


Next up:

Create user/password functionality

create registration by email

Should do:

need to change the client to import levels individually, the returnAll api causes a significant increase in CPU usage at this point. This needs to be implemented here in controller and repository classes. I must've removed that prior to last commit.

add arrows to move view point in level editor

Change alerts & url for level editor
