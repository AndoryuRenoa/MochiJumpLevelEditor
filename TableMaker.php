// this will house the working code for using PHP to add to the mySQL database. Once complete it can be moved/renamed elsewhere

/** the time has come to try to move data from the mJLE page to else where. In order to do this I will need a PHP script
* okay so current project: move arrays containing svg rectangles to and from the database: the below is just for creating a new table
* and it is pretty much done.
**/

<?php
$severname = ""//add server name
$username = ""//add username
$password = ""//add password
$dbname = ""//add database! add database name
$tablename = htmlspecialchars($_POST['q']); // I think this is correct; the special chars should help avoid exploits

//I'm going to attempt to uses sessions to carry over the variable $tablename across different php files

sessions_start();
$_  SESSION['tablename']=$tablename;

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error){
  die("Connection failed: ".$conn->connect_error);
}
  // below table will always have the same rows
$sql = "CREATE TABLE $tablename (
startX INT(),
startY INT(),
width INT(),
height INT(),
)

if ($conn->query($sql) === true){
  echo "New Level Name accepted";
} else {
  echo "Errpr creating new level: ". $conn->error;
}

$conn-> close();
?>
