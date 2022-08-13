function quadradoNum() {
    var i;
     for(i=1; i<=20; i*i){
         document.write(i,'- ');
     }
 }
 
 function numPar() {
    var i;
         for(i=1; i<=600; i++){
             if (i % 2==0) {
                 document.write(i,'-');
             }
         }
         document.write(i, '. ');
 }
 
 function num10() {
     var i, soma=0;
     for(i=1; i<=9; i++){
       document.write(i,'-');
       soma=soma+i;
     }
     document.write(i,'. ');
     document.write('<hr> soma: ',soma,'<hr>');
 }
 
 function somaPar() {
    var i, soma=0;
    for(i=24; i<=200; i++){
      if (i % 2==0) {
          soma=soma+i;    
      }
    }
    document.write('<hr> soma: ',soma,'<hr>');
 }
  function somaN() {
     for(i=0; i<=N; i++){
       soma=soma+i;
     }
     document.write('soma: ',soma)
  }
  function tabuadaNum() {
      
      for(i=1; i<=10; i++){
       document.write(num,'x',i,'=',num*i,'<hr>')
      }
  }
 
  function tabuadaI() {
      for(num=1; num<=10; num++){
         for(i=0; i<=10; i++){
            document.write(num,'x',i,'=',num*i,'<hr>')
         }
      }
  }
 
  function limite() {
      for(i=1; i<=num; i++){
        if ( i% 2 ==! 0) {
            document.write(i,' <br>');
        }
      }
      
  }
 
  function saidas() {
     for(i=2 ; cont < num; i++) {
      if (i % 2  == 0 ) {
         document.write(i,' -');  
         cont++;
       }
     } 
 }
 
 function somarNums() {
     soma = soma+num;
 }
 function mediaNums() {
     media = soma/10;
 }
 function maiorNums() {
     if (i==1) {
         maiornum=num;
     }
     if (num > maiornum) {
         maiornum = num;
     }
 }
 function menorNums() {
     if (i==1) {
         menornum=num;
     }
     if (num < menornum) {
         menornum=num;
     }
 }
  
 function maiorSalario() {
     if (i==1) {
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
  function multiploN() {
      document.write('Os ',K,' multiplos do número ',N,' são: <hr>');
      for(i=1; i<=K; i++){
        multiplos=N*i;
        document.write(multiplos,' <hr>');
      }
  }
  function somaSucess() {
    for(cont=1; cont <= N2; cont++){

        soma += N1;
     }
     document.write('A soma sucessiva do número ',N1,' pelo número ',N2,' é: ',soma);
  }