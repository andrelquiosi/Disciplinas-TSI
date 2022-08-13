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
                document.write(matriz[i][j],' - ');
            }else{
                 document.write(matriz[i][j],' <br> ');
            }
        }
    }
}