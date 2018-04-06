<? PHP
$severname = ""//add server name
$username = ""//add username
$password = ""//add password
$dbname = ""//add database! add database name
  
sessions_start();
$tablename=$_  SESSION['tablename'];
  
$conn = new mysqli ($servername, $username, $password, $dbname);
if ($conn->connect_error){
   die("Connection failed: ".$conn->connect_error);
}

  
  //Need to remove previous rows from table
$deleteRows = "Delete * from $tablename";

if (conn -> query($deleteRows) === true){
  // optionally put something here
} else {
  // optionally put something here, however if this is the first time saving the level this will always fail
} 
  //Need to submit JSON value into rows for table (last step)
  
$conn-> close();  
  ?>
