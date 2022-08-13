<?php

ini_set('display_erros',1);
ini_set('display_startup_erros',1);
error_reporting(E_ALL);

session_start();

if (!isset($_SESSION['cont'])){
    $_SESSION['cont'] = 0;
}else{
    $_SESSION['cont']++;
}

if($_SESSION['cont'] == 5){
    unset($_SESSION['cont']);
    echo "Desregistrando variavel";

}else{
    echo $_SESSION['cont'];
}
?>