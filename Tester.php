<?php

// simple script to create test database, table, and two rows inside of it will be used to test retreival functionality
$servername = "localhost";
$username = "input";
$password = "input";
$dbname = "levelDB";
$tablename = "testerTable";

$conn = new mysqil($servername, $username, $password);

$if ($conn->connect_error){
  die("Connection failed: ".$conn->connect_error);
}

// create database
$sql = "CREATE DATABASE $dbname";
if ($conn->query($sql) === true){
  echo "Database created successfully";
}else{
  echo "Error: "conn.error;
}

$sql2 = "CREATE TABLE $tablename(
startX INT(),
startY INT(),
width INT(),
height INT(),
)";
if ($conn->query($sql2) === true){
  echo "Table created successfully";
}else{
  echo "Error: "conn.error;
}

$sql3 = "Insert into $tablename (startX, startU, width, height)
values (5,5, 50,50), (100,100,50,50)"

if($conn->queary($sql3) === true){
  echo "Insertion Complete";
}else{
  echo "Error: "conn.error;
}

//end
$conn->close();

?>
