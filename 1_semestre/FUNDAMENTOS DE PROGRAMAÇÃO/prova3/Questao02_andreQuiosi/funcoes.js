function preencherVetor(n) {
    var vet = [];
    for (var i = 0; i < n; i++) {
        vet[i] = Number(prompt("Informe o " + (i+1) +"º Valor"));
    }
    return vet;
}

function exibirVetor(n, vet) {
    for (var i = 0; i < n; i++) {
        document.write("Vetor [", i, "]= ", vet[i], "<br>");
    }
}

function ordemCrescente(n, vet) {
    var aux = 0;
    for (i = 0; i < n; i++) {
        for (j = i + 1; j < n; j++) {
            if (vet[i] > vet[j]) {
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux
            }
        }
    }
    return vet;
}

function ordemDecrescente(n, vet) {
    var aux = 0;
    for (i = 0; i < n; i++) {
        for (j = i + 1; j < n; j++) {
            if (vet[i] < vet[j]) {
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux
            }
        }
    }
    return vet;
}

function acharMaior(n,vet){
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

function acharMenor(n,vet){
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

function somarVetor(n,vet){
    var soma=0;
    for(var i=0; i < n; i++){
        soma = soma + vet[i];
    }
    return soma;
}

function contarPares(n,vet){
    var pares=0;
    for(var i=0; i < n; i++){
        if(vet[i] % 2 == 0){
            pares++;
        }
    }
    return pares;
}
function contarImpares(n,vet){
    var impares=0;
    for(var i=0; i < n; i++){
        if(vet[i] % 2 != 0){
            impares++;
        }
    }
    return impares;
}

function somarImpares(n,vet){
    var somaImp=0;
    for(var i=0; i < n; i++){
        if(vet[i] % 2 != 0){
            somaImp += vet[i];
        }
    }
    return somaImp;
}

function somarPares(n,vet){
    var somaPar=0;
    for(var i=0; i < n; i++){
        if(vet[i] % 2 == 0){
            somaPar += vet[i];
        }
    }
    return somaPar;
}