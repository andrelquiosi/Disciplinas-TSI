<?php
// Your code here!
//$mycalc = new MyCalculator(12,6);
//echo $mycalc->add() . "\n";
// $mycalc->sub() . "\n";
//echo $mycalc->mult() . "\n";
//echo $mycalc->div();

class MyCalculator{
    
    private $val1 = 0;
    private $val2 = 0;
    
    public function __construct($valor1, $valor2){
        $this->val1 = $valor1;
        $this->val2 = $valor2;
        
    }
    
    public function add(){
        return $this->val1 + $this->val2;
    }
        public function sub(){
        return $this->val1 - $this->val2;
    }
        public function mult(){
        return $this->val1 * $this->val2;
    }
        public function div(){
         if($this->val1 != 0 && $this->val2 != 0){
          return $this->val1 / $this->val2;
         }else{
          return 0;
         }
    }
}
class Calc_nova extends MyCalculator{
 
 
 function fatorial($n){
    
    if($n > 0){
        return($n * fatorial($n - 1));
    }else{
        return 1;
    }
}
}

//////////////////////////////////////////////////////////////
// Your code here!


$animal = new Animal(2);
echo $animal->emitir_som() . "\n";
$animal = new Cachorro(2);
echo $animal->emitir_som() . "\n";
$animal = new Gato(2);
echo $animal->emitir_som() . "\n";

class Animal{
 
 public $tamanho, $som;
 function __construct($tamanho){
  $this->tamanho = $tamanho;
 }
 public function emitir_som($som = "Emitir som!"){
  echo $som;
 }
}
class Cachorro extends Animal{
 
 public function emitir_som($som = "Auau!!"){
  echo $som;
 }
 
}
class Gato extends Animal{
 
 public function emitir_som($som = "Miau!"){
  echo $som;
 }

}
///////////////////////////////////////////////////////////////

class Aluno{
 public $nome, $n1, $n2, $media;
 public function __construct($nome, $n2,$n2){
  
  
  
  
 }
}
$aluno = ["andre", "8", "7"];

media_alunos($aluno);

function media_alunos($aluno){
  foreach ($aluno as $array1){
  $media = $array1[1] + (2 * $array1[2]);
  echo $media;
 }
 
}

?>
