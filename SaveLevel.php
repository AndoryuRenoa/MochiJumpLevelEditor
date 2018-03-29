<? PHP
$severname = ""//add server name
$username = ""//add username
$password = ""//add password
$dbname = ""//add database! add database name
$tableName = "" // need to be sure that the table name and the JSON array are accessed properly
  
$conn = new mysqli ($servername, $username, $password, $dbname);
if ($conn->connect_error){
   die("Connection failed: ".$conn->connect_error);
}
  /** I think the solution for tableName getting it's value here is to use include"tableMaker.php"
  * will need to write a simple test to determine that TableMaker.php actually returns a value and then check "RetreiveTable.php"
  * something like include (tableMaker.php);
  * if (tableName == null){
  * include(RetreiveTable.php);
  *}
  * solution may also to use tags when posting via js i.e. "SaveLevel.php?q=t"
  * for further reading: https://www.w3schools.com/php/php_includes.asp **/
  
  //Need to remove previous rows from table
  
  //Need to submit JSON value into rows for table
  
$conn-> close();  
  ?>
