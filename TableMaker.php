/** the time has come to try to move data from the mJLE page to else where.
* the below code needs to be tested, this however lays the framework for how to get the svg objects from JS to PHP to SQL
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
