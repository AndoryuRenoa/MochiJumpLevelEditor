// this will house the working code for using PHP to add to the mySQL database. Once complete it can be moved/renamed elsewhere

/** the time has come to try to move data from the mJLE page to else where. In order to do this I will need a PHP script
* okay so current questions:
* 1. will SQL let you write a new table over an old one?
* http://php.net/manual/en/reserved.variables.post.php
**/

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
