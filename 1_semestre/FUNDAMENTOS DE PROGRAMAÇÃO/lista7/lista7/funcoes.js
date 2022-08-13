function quadradoNum() {
    do{
      document.write(num*num,' <br>');
      num++;
    }while(num<=20)

}
function todosPares() {
  do{
      document.write(num,' <br>');
      num=num+2;
  }while(num<=600)
}
function somarNums() {
  soma=soma+num;
}
function somaPar() {
  if (i % 2==0) {
    soma=soma+i;    
}
  
  }
  function  somaN() {
    do {
      soma=soma+i;
      i++;
    } while (i<=N)
    document.write(' ',soma,'<hr>');
  }
  function tabuada() {
     do {
      document.write(num,'x',i,'=',num*i,'<hr>');
      i++;
     } while (i<=10);
  }
  function tabuadaNum() {
    do {
      for(i=0; i<=10; i++){
        document.write(num,'x',i,'=',num*i,'<hr>');
      }
      num++;
    } while (num<=10);
  }
   function limiteImpar() {
    if ( i% 2 ==! 0) {
      document.write(i,' <br>');
  }
   }
   function saidas() {
     
    if ( cont % 2 == 0) {
      document.write(cont,' <br>');
  }
}
function somar() {
  soma=soma+num;
}
function mediaNum() {
  media = soma/10;
}
function maiorNum() {
  if (cont==1) {
    maiornum=num;
}
if (num > maiornum) {
    maiornum = num;
}
}
function menorNum() {
  if (cont==1) {
    menornum=num;
}
if (num < menornum) {
    menornum=num;
 }
}
function numeroParImpar() {
  if (cont%2==0) {
    document.write('a- O número ',cont, ' é par.<hr>');
  }else{
    document.write('a- O número ',cont, ' é impar.<hr>');
  }
}
function par() {
  if(num%2==0)
  numPar=numPar+1;
}
function impar() {
  if (num%2==!0) {
    numImpar=numImpar+1;
  }
}
function maiorSalario() {
  if (cont==1) {
      maiorsal=sal;   
  }
  if (sal > maiorsal) {
      maiorsal = sal;
      nomeMaior= func;
  }
}
function contarMedias() {
  if(media>7){
      mediaMaior7=mediaMaior7+1;
  }
}
function zerarContMedias() {
  mediaMaior7=0;
}
function somarMedias() {
  somaMedias=somaMedias+media;
}
function contarMediasGeral() {
  qtdMedias= qtdMedias+1;
}
function calcularMediaGeral() {
  mediaGeral= somaMedias/qtdMedias;
}
function sequência() {
  if (i==1) {
      document.write('0, ');
  }
  if (i==2) {
      document.write('1, ');
  }
  if (i>2) {
      soma=n1+n2;
      n1=n2;
      n2=soma;
      document.write(soma,', ');
  }
}
function multiplosN() {
  document.write('Os ',K,' primeiros multiplos do número ',N,' são: <hr>');
  while (i<=K) {
    multiplos=N*i;
        document.write(multiplos,' <hr>');
    i++;    
  }
}
function somaSucess() {
  while(cont <= N2 ){

      soma += N1;
      cont++;
   }
   document.write('A soma sucessiva do número ',N1,' pelo número ',N2,' é: ',soma);
}
