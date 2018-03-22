// this will house the working code for using PHP to add to the mySQL database. Once complete it can be moved/renamed elsewhere

/** the time has come to try to move data from the mJLE page to else where. In order to do this I will need a PHP script
* as I am completely unfamiliar with PHP this test.php will serve as my starting point for this.
* 
* I'm creating a local server using bitnami as a starting point. Bitnami has a tonne of stuff inside it.
* For now I'm just going to try to get the 
*
* Okay, well to get the following to work it actually needed to be inside of <html> tags for some reason. Not sure why exactly.. 
* current location: http://www.freewebmasterhelp.com/tutorials/phpmysql/2 **/


<?php
$severname = ""//add server name
$username = ""//add username
$password = ""//add password
$dbname = ""//add database! add database name
$tablename; //this will be sent over via js

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error){
  die("Cpnnection failed: ".$conn->connect_error);
}
  // below table will always have the same rows
$sql = "CREATE TABLE $tablename (
startX INT(),
startY INT(),
width INT(),
Height(),
)

if ($conn->query($sql) === true){
  echo "New Level Name accepted";
} else {
  echo "Errpr creating new level: ". $conn->error;
}

// still need to fill in the level with the data passed by JS

$conn-> close();
?>
