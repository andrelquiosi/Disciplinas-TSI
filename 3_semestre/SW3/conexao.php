<?php

// $mysqli = new mysqli("localhost","aluno","teste$123");
// echo "Info 1: " . $mysqli->host_info . "<br>";

// $mysqli = new mysqli("127.0.0.1","aluno","teste$123","","3306");
// echo "Info 2: " . $mysqli->host_info . "<br>";


// $mysqli = new mysqli("localhost","aluno","teste$123");
// $result = $mysqli -> query("show databases;");
// //var_dump($result);
// echo "<table border=\"2\"><tr>Database</tr></table>";
// foreach($result as $res){
// echo "<table>
// <tr>
// var_dump($res)
// </tr>
// </table>";
// }

try{
$dbh = new PDO('mysql:host=localhost;', "aluno","teste$123");
} catch(PDOException $e){
    print( "Error!: " . $e->getMessage() . "<br/>");
    die();
}
try{
    $data = $dbh -> query("show databases");
    foreach ( $data as $key) {
        print_r($key);
    }
    } catch(PDOException $e){
        print( "Error!: " . $e->getMessage() . "<br/>");
        die();
    }

?>