
<? PHP
$severname = ""//add server name
$username = ""//add username
$password = ""//add password
$dbname = ""//add database! add database name
$tablename= htmlspecialchars($POST[q]);


sessions_start();
$_  SESSION['tablename']=$tablename;

// first test requires checking that the table name actually exists

// still need to write how to retrieve this PHP, then how to format it so that it can be given to js and read by js (JSON)

/** Okay so what I want to do is request all rows within the table
* then I want to assign column one to Array[1] and it should contain values for x,y,width,height
*then convert everything in array to JSON
* then in js convert JSON to an array, then inside the array for i=0, i>lenght, i++ assign the four values  in 
* array[i] to svg (x,y,width,heigh).
* run tester.php or input level prior to attempting to run level retriever
* requires alert if tablename does not match anything in db.
**/

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error){
  die("Connection failed: " . $conn->connect_error);
}
$sql = "SELECT * from $tablename";
// result here will need to be an array

$result = $conn->query($sql);

if ($result -> num_rows >0){
  while ($row  = $result->fetch_assoc()){
    //okay here we need to create an object to later convert to JSON that will pick up and return the svgs to the js
    $toBecomeJSON = array($row["startX"],$row["startY"],$row["width"],$row["height"];
  }
$JSONobject = json_encode($toBecomeJSON);
echo $JSONobject;
}
 else{
   echo "This name is not in the database";
 }
// need to arrange result output in js!
  
  
  
  ?>
