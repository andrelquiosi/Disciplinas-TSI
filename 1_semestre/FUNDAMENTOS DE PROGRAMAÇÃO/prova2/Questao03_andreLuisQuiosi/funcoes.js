function totalVotNulo(){
    if(voto == -1){
        nulo += 1;
    }
}
function totalVotBranco(){
    if(voto == 0){
        branco += 1;
    }
}
function totalVotosCand(){
    if(voto == 1){
        candidato1 += 1;
    }
    if(voto == 2){
        candidato2 += 1;
    }
    if(voto == 3){
        candidato3 += 1;
    }
}
function totalVenc(){
    if((candidato1 > candidato2) && (candidato1 > candidato3)){
        document.write("O candidato 1 é o vencedor com: ",candidato1, "<hr>");
    }
    if((candidato2 > candidato1) && (candidato2 > candidato3)){
        document.write("O candidato 2 é o vencedor com: ",candidato2, "<hr>");
    }
    if((candidato3 > candidato2) && (candidato3 > candidato1)){
        document.write("O candidato 3 é o vencedor com: ",candidato3, "<hr>");
    }
}
function semVenc(){
    somaSemVenc = nulo + branco;
    if(branco == N || nulo == N || somaSemVenc == N){
        document.write("A população anulou a eleição!<hr>");
    }
}


