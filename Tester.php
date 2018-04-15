<?php

// simple script to create test database, table, and two rows inside of it will be used to test retreival functionality
$servername = "localhost";
$username = "input";
$password = "input";

$conn = new mysqil($servername, $username, $password);

$if ($conn->connect_error){
  die("Connection failed: ".$conn->connect_error);
}

// create database
$sql = "CREATE DATABASE levelDB";
if ($conn->query($sql) === true){
  echo "Database created successfully";
}else{
  echo "Error: "conn.error;
}

?>
