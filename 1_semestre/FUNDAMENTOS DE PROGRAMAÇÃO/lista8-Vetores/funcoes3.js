function preencherVetor(n){
    var vet=[];
    for(var i=0; i < n; i++){
        vet[i] = Number(prompt('Informe o valor: '));
    }
    return vet;
}
function exibirVetor(vet, n){
    for(var i=0; i < n; i++){
        document.write('vetor[',i,']= ',vet[i],'<br>');
    }
}
function acharMaior(vet, n){
    var maior;
    for(var i=0; i < n; i++){
        if(i==0){
            maior = vet[i];
        }else if(vet[i] > maior){
            maior = vet[i];
        }
    }
    return maior;
}
function acharMenor(vet, n){
    var menor;
    for(var i=0; i < n; i++){
        if(i==0){
            menor = vet[i];
        }else if(vet[i] < menor){
            menor = vet[i];
        }
    }
    return menor;
}
function somarVetor(vet, n){
    var soma=0;
    for(var i=0; i < n; i++){
        soma = soma + vet[i];
    }
    return soma;
}
function calcularMedia(soma, qtNums){
    var media = soma / qtNums;
    return media;
}
function contarPares(vet, n){
    var pares=0;
    for(var i=0; i < n; i++){
        if(vet[i] % 2 == 0){
            pares++;
        }
    }
    return pares;
}
function contarImpares(vet, n){
    var impares=0;
    for(var i=0; i < n; i++){
        if(vet[i] % 2 != 0){
            impares++;
        }
    }
    return impares;
}


















