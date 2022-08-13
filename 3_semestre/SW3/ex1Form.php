
 <html>

<form method="post" action="<?php echo $_SERVER['PHP_SELF'];?>">

 Name: <input type="text" name="name" />
<input type="submit" value="Enviar"/>
</form>
 <?php 
if($_SERVER['REQUEST_METHOD'] == 'POST'){
echo strlen($_POST['name']) > 0 ? $_POST['name'] : "nome não informado";
}
?>
</html>

