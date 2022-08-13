 <html>

<form method="post" action="<?php echo $_SERVER['PHP_SELF'];?>">

Name: <input type="text" name="name" />
<input type="submit" value="Enviar"/>
<a href = "?ApagarHistorico=true" >Apagar historico</a>
</form>

 <?php

 ini_set('display_erros',1);
 ini_set('display_startup_erros',1);
 error_reporting(E_ALL);
 
session_start();

if (!isset($_SESSION['hist']) || isset($_GET['ApagarHistorico']) && $_GET['ApagarHistorico'] == true) {
    $_SESSION['hist'] = array();
}else{
    array_push($_SESSION['hist'], $_POST['name']);
}
if(isset($_GET['Apagar'])){
    array_splice($_SESSION['hist'], $_GET['Apagar'],1);
}


for ($i=0; $i < count($_SESSION['hist']); $i++) { 

    echo $_SESSION['hist'][$i] . "<a href = \"?Apagar=".$i."\" >Apagar</a>". "<br>";
}

?>

</html>