function mostraParImpar() {
    if (num % 2 == 0) {
        document.write("O ", num, " é par <br>");
        numPar = num;
    } else if (num % 2 != 0) {
        document.write("O ", num, " é impar <br>");
        numImpar = num;
    }
}

function somPares() {
    if (num % 2 == 0) {
        somPar = somPar + num;

    }
}

function somImpares() {
    if (num % 2 != 0) {
        somImp = somImp + num;
    }

}

function maiorMenorImparPar() {

    var valMaior;
    valMaior = numPar;

    if (valMaior >= numPar) {
        maiorNumPar = valMaior;
    }

    if (num % 2 ==! 0) {
        if (cont == 1) {

            menorNumImpar = num;
        }
        if (menorNumImpar > num) {

            menorNumImpar = num;
        }

    }
}

function totalPar() {
    if (num % 2 == 0) {
        totPar += 1;
    }
}

function totalImpar() {
    if (num % 2 != 0) {
        totImpar += 1;

    }
}