function mensagemGeral() {
  alert("Parabéns");
}
function mensagemPersonalizada(nome){
  alert("Parabéns "+ nome);
}
function exibirSituacao(nota,media){
  if (prova1 >= media){
    alert("Aprovado");
  }else{
    alert("Reprovado");
  }
}
function retornaSituacao(nota,media){
  var situacao;
  if (prova1 >= media){
    situacao = "Aprovado";
  }else{
    situacao = "Reprovado";
  }
  return situacao;
}
function metade(num){
  return num/2;
}
function dividir(num,por){
  return num / por;
}
function quadrado(numero){
  if(isNaN(numero)){
    return "Entrada invalida! Precisa ser um numero!";
  }
  quad = numero * numero;
  return quad;
}
function pedirCOmida(){
  document.write(comida + "<br");
}
