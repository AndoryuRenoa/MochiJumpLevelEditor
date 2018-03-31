
<? PHP
$severname = ""//add server name
$username = ""//add username
$password = ""//add password
$dbname = ""//add database! add database name
$tablename= htmlspecialchars($POST[q]);

sessions_start();
$_  SESSION['tablename']=$tablename;

// still need to write how to retrieve this PHP, then how to format it so that it can be given to js and read by js (JSON)


  
  
  
  ?>
