
<? PHP
$severname = ""//add server name
$username = ""//add username
$password = ""//add password
$dbname = ""//add database! add database name
$tablename= htmlspecialchars($POST[q]);

sessions_start();
$_  SESSION['tablename']=$tablename;

// still need to write how to retrieve this PHP, then how to format it so that it can be given to js and read by js (JSON)

/** Okay so what I want to do is request all rows within the table
* then I want to assign column one to Array[1] and it should contain values for x,y,width,height
*then convert everything in array to JSON
* then in js convert JSON to an array, then inside the array for i=0, i>lenght, i++ assign the four values  in 
* array[i] to svg (x,y,width,heigh).
* At this stage I'm thinking of creating a db and test with test values in it so see if I can retrieve this properly
**/

  
  
  
  ?>
