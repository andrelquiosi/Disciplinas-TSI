<?php

function somatodos(... $args){
   $resultado = 0;
   foreach($args as  $arg){
       $resultado += $arg;
   }
   return $resultado;

}
echo somatodos(1,2,3);
?>