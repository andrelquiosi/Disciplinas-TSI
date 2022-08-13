<?php
//fatorial

function fatorial($n){
    
    if($n > 0){
        return($n * fatorial($n - 1));
    }else{
        return 1;
    }
}

$valor = 5;

echo "o fatorial de $valor é :: " . fatorial($valor);
?>