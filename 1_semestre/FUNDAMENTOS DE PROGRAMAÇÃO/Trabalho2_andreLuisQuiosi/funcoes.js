function contarMediaMenor7Turma() {
    if (media < 7) {
        qtMenor7Turma += 1;
    }
}

function contarMediaMaior7Turma() {
    if (media >= 7) {
        qtMaior7Turma += 1;
    }
}

function contarMediaMenor7Escola() {
    if (media < 7) {
        qtMenor7Escola += 1;
    }
}

function contarMediaMaior7Escola() {
    if (media >= 7) {
        qtMaior7Escola += 1;
    }
}

function localizarMenorMaiorMedia() {
    var mediaMenor1, mediaMaior1;
    mediaMenor1 = media;
    mediaMaior1 = media;

    if (mediaMenor1 < mediaMenor || mediaMenor == 0) {
        nomeMenor = nome;
        mediaMenor = mediaMenor1;
    }
    if (mediaMaior1 >= mediaMaior || mediaMaior == 0) {
        nomeMaior = nome;
        mediaMaior = mediaMaior1;
    }
}

function somarMediasTurma() {
    totalMediaTurma = totalMediaTurma + media;

}

function somarMediasEscola() {
    totalMediaEscola += media;
}

function contarAlunos() {
    totalAlunos += 1;
}

function calcularMediaTurma() {
    mediaTurma = totalMediaTurma / qtdAlunos;

}

function calcularMediaEscola() {
    mediaEscola = totalMediaEscola / totalAlunos;
}

function calcularPercentuais() {
    percMaior7Escola = (qtMaior7Escola * 100) / totalAlunos;
    percMenor7Escola = (qtMenor7Escola * 100) / totalAlunos;
}

function zerarTotalMediaTurma() {
    totalMediaTurma = 0;

}

function zerarQtMenorMaior7() {
    qtMenor7Turma = 0;
    qtMaior7Turma = 0;
    aluno = 1;
    mediaTurma = 0;
    media = 0;
    mediaMaior = 0;
    mediaMenor = 0;
    mediaMaior1 = 0;
    mediaMenor1 = 0;
}