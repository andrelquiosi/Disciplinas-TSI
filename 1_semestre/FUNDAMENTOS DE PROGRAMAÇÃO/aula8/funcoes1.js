function geraListagem(){
    var i;
    for(i=1; i<=10; i++){
        document.write(i , " - ");
    }
    document.write(i , ". ");
}

function geraListagemDecrecente(){
    var i;
    for(i=20; i>1; i--){
        document.write(i , " - ");
    }
    document.write(i , ". ");
}

function sapo(){
    var i;
    for(i=1; i<=20; i++){    
        if((i == 10) || (i == 20)){
            document.write(i, " - Sapo pula <br>");
        }else {
            document.write(i + " - O sapo pula <br>");
        }
    }
}
function somar(){
    soma= soma +i;
}
function somar2(){
    soma = entrada + soma;
}