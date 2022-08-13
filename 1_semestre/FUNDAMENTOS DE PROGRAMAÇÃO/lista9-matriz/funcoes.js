function preencherMatriz(lin, col){
    var mat=[];
    for(var i=0; i < lin; i++){
        mat[i] = [];
        for(var j=0; j < col; j++){
            mat[i][j] = Number(prompt('Informe o valor: '));
        }
    }
    return mat;
}
function exibirMatriz(mat, lin, col){
    for(var i=0; i < lin; i++){
        for(var j=0; j < col; j++){
            document.write('matriz[',i,'][',j,']= ',mat[i][j],'<br>');
        }
    }
}
function exibirMatriz2(mat, lin, col){
    for(var i=0; i < lin; i++){
        for(var j=0; j < col; j++){
            if(j < col-1){
                document.write(mat[i][j],' - ');
            }else{
                 document.write(mat[i][j],' <br> ');
            }
        }
    }
}
function acharMaior(mat, lin, col){
    var maior;
    for(var i=0; i < lin; i++){
        for(var j=0; j < col; j++){
           if(i==0 & j==0){
               maior = mat[i][j];
           }
           if(mat[i][j] > maior){
               maior = mat[i][j];
           }   
        }
    }
    return maior;
}
function gerarMatrizResultante(mat, lin, col, maior){
    var matR=[];
    for(var i=0; i < lin; i++){
        matR[i] = [];
        for(var j=0; j < col; j++){
            matR[i][j] = mat[i][j] * maior
        }
    }
    return matR;
}
function somarLinhas(mat, lin, col){
    var somaL=[];
    for(var i=0; i < lin; i++){ // entramos na linha da matriz
        somaL[i] = 0;
        for (var j=0; j < col; j++){ //percorremos todas as colunas da linha atual
            somaL[i] = somaL[i] + mat[i][j];
        }
    }
    return somaL;
}
function exibirVetor(vet, n){
    for(var i=0; i < n; i++){
        document.write('Linha ',i,': ',vet[i],'<br>');
    }
    
}
function somarColunas(mat, lin, col){
    var somaC=[];
    for(var j=0; j < col; j++){//entramos na coluna da matriz
        somaC[j]=0;
        for(var i=0; i < lin; i++){// percorrermos todas as linhas da coluna atual
            somaC[j] = somaC[j] + mat[i][j];
        }
    }
    return somaC;
    
}
function exibirVetor2(vet, n){
    for(var i=0; i < n; i++){
        document.write('Coluna ',i,': ',vet[i],'<br>');
    }
    
}
function somarMatriz(mat, lin, col){
    var soma=0;
    for(var i=0; i < lin; i++){
        for(var j=0; j < col; j++){
            soma = soma + mat[i][j];
        }
    }
    return soma;
}
function calcularMedia(soma, lin, col){
    var media = soma / (lin * col);
    return media;
}
function preencherMatriz2(lin, col){
    var mat=[];
    for(var i=0; i < lin; i++){
        mat[i] = [];
        mat[i][0] = prompt('Informe o nome do cliente '+ i+': ');
        for(var j=1; j < col; j++){
            mat[i][j] = Number(prompt('Informe o valor: '));
        }
    }
    return mat;
}
function exibirMatriz2(mat, lin, col){
    for(var i=0; i < lin; i++){
        document.write('<br><b> Compras do cliente: ',mat[i][0],'</b><br>')
        for(var j=1; j < col; j++){
            document.write('Compra',j,': ',mat[i][j],'<br>');
        }
    }
}
