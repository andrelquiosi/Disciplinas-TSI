
 <html>

<form method="post" action="<?php echo $_SERVER['PHP_SELF'];?>">

<select name = "numero" onchange= "this.form.submit()">

    <?php

    for ($i=1; $i <= 10; $i++) {
        if($_POST['numero'] == $i){
            echo "<option value = $i selected>$i</option>";
        }else{
            echo "<option value = $i>$i</option>";
        }
    }


    ?>
    </select>

</form>
<?php

for ($j=1; $j <= 10; $j++) { 
    echo "<br>" . $j . " * ". $_POST['numero']. "= " . $j * $_POST['numero'];
}
?>
</html>

