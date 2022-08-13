<?php
// Your code here!
if(false){
   $valorA = -5;
$valorB = 6;

for ($i = $valorA + 1; $i < $valorB; $i++) {
    echo  $i . "\n";
    
} 
}


////////////////////////////////////
if(false){
   $valorC = 6;

for ($i = 1; $i <= $valorC; $i++) {
    for ($j = 1; $j <= $i; $j++) {
        
echo $j;
    }
    echo "\n";
} 
}


////////////////////////////////////
if(false){
    
$string = "a123b123";
$inteiro = 2;

if( strlen($string) % $inteiro == 0 ){
    for ( $i = 0; $i < strlen($string); $i++) {
        
        if($i % (strlen($string) / $inteiro) == 0){
            echo "\n";
        }
            echo $string[$i];
    }
    
}


for($i = 0; $i < strlen($string); print(($i % (strlen($string) / $inteiro) == 0 ? "\n" : ""). $string[$i++]));
    
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(false){
 
$string = "qqwwweeeerrrrrtyy";
$cont = 1;

for ($i = 0; $i < strlen($string)-1; $i++) {

    if($string[$i] == $string[$i + 1]){
        $cont ++;
    }else{

        echo $string[$i] . $cont;
        $cont = 1;
    }
}
        echo $string[$i] . $cont;
        
}
///////////////////////////////////////////
if(true){
    
    $val = 11;
    
function fib($n){
    if($n<2) return $n;
    return fib($n-1) + fib($n-2);
}

for($i=0;$i<$val;$i++){
    echo fib($i) . " ";
}
    
}

?>
