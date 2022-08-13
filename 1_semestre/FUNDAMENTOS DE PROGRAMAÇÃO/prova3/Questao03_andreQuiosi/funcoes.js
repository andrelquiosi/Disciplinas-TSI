function preencherMatriz(lin, col){
    var mat=[];
    for(var i=0; i < lin; i++){
        mat[i] = [];
        for(var j=0; j < col; j++){
            mat[i][j] = Number(prompt("Informe quantidade do produto [ "+(i+1) +" ] vendidos no Mês - "+(j+1)));
        }
    }
    return mat;
}

function exibirMatrizTab(mat, lin, col){
    for(var i=0; i < lin; i++){
        document.write("Produto ",(i+1),": ");
        for(var j=0; j < col; j++){
            if(j < col-1){
                document.write(" Mês ", (j+1) ," = ",mat[i][j]," - ");
            }else{
                 document.write(" Mês ", (j+1) ," = ",mat[i][j]," <br> ");
            }
        }
    }
}
////////////////////////////////////////////////////////////
function somarVendMes(mat, lin, col){
    var somaM=[];
    for(var j=0; j < col; j++){
        somaM[j]=0;
        for(var i=0; i < lin; i++){
            somaM[j] = somaM[j] + mat[i][j];
        }
    }
    return somaM;
}
///////////////////////////////////////////////
function somarVendaProduto(mat, lin, col){
    var somaP=[];
    for(var i=0; i < lin; i++){
        somaP[i] = 0;
        for (var j=0; j < col; j++){
            somaP[i] = somaP[i] + mat[i][j];
        }
    }
    return somaP;
}
////////////////////////////////////////////////////////////
function exibirSomaProduto(vet, n){
    for(var i=0; i < n; i++){
        document.write('Produto ',(i+1),'= ',vet[i],'<br>');
    }
    
}
//////////////////////////////////////////////////
function exibirSomaMes(vet, n){
    for(var i=0; i < n; i++){
        document.write('Mês = ',(i+1),': ',vet[i],'<br>');
    }
}
////////////////////////////////////////////////////////////
function somarMatriz(mat, lin, col){
    var soma=0;
    for(var i=0; i < lin; i++){
        for(var j=0; j < col; j++){
            soma = soma + mat[i][j];
        }
    }
    return soma;
}
/////////////////////////////////////////////////////
function calcularMediaMensal(soma,li, col){
    var media=[];
    for(var j=0; j < col; j++){
        media[j]=0;
            media[j] = soma[j] / li;

    }
    return media;
}
