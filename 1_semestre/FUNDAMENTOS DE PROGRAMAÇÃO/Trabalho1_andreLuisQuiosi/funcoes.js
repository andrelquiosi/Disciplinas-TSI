function contMenor18(){
if (idade < 18){
    menor18 = menor18 + 1;
}
}
function somarIdades(){
   somaIdades = somaIdades + idade; 
}
function contarJogadores(){
    contJog = contJog + 1;
}

function mediaIdadePorTime(){
    mediaIdades = somaIdades / (jogador - 1);
}
function zerarSomaIdades(){
    somaIdades = 0;
    
}
function calculaPercentual80(){

    percentual80 = (cont80 * 100) / contJog;

}
function somarAlturas(){
    somaAlturas = somaAlturas + altura;
}
function mediaAlturaCampeonato(){
    medAlturas = somaAlturas / contJog;
}
function contarPesosAcima80(){
    if( peso > 80){
        cont80 = cont80 + 1;
    }

}
