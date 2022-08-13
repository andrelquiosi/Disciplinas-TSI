function preencheNotas(l, c) {
    var m = [];

    for (i = 0; i < l; i++) {//esse for percorre as linhas da matriz
        m[i] = [];
        alert('Informando as notas do aluno ' + (i+1));
        for (j = 0; j < c; j++) {//esse for percorre as colunas para adicionar valor a elas
            m[i][j] = Number(prompt('Informe a nota da prova ' + j + ': '));
        }
    }
    return m;
}

function exibeMatriz(m, l, c) {
    for (i = 0; i < l; i++) {
        document.write('<br> Notas do aluno ' + (i+1) + ': <br>')
        for (j = 0; j < c; j++) {
            document.write('Prova ' + (j+1) + ': ', m[i][j], '<br>');
        }
    }
}

function buscaProvaComMenorNota(m, l, c) {
    var menorNota, provaMenor = [];
    for (i = 0; i < l; i++) {
        menorNota = m[i][0]; // menorNota recebe o valor que estiver na posição [0][0] da matriz, ou seja a primeira nota
        provaMenor[i] = 0; // provaMenor na posição inicial [0] recebe o número da coluna onde está a primeira nota
        for (j = 0; j < c; j++) {
            if (m[i][j] < menorNota) {
                menoresNotas = m[i][j]; // guarda o valor da nota
                provaMenor[i] = j; // guarda a posição/coluna da nota
            }
        }
    }
    return provaMenor;

}

function exibeVetor(vet) {
    for (i = 0; i < vet.length; i++) {
        document.write('O aluno ', i, ' obteve a menor nota na prova ', vet[i], '<br>');
    }
}

function contarProvas(vet, c) {
    var contProva = [];
    for (i = 0; i < c; i++) {
        contProva[i] = 0;
    }
    for (i = 0; i < vet.length; i++) {
        if (vet[i] == 0) {
            contProva[0] = contProva[0] + 1;
        }
        if (vet[i] == 1) {
            contProva[1] = contProva[1] + 1;
        }
        if (vet[i] == 2) {
            contProva[2] = contProva[2] + 1;
        }
    }
    return contProva;
}


function exibeVetor2(vet, c) {
    for (i = 0; i < c; i++) {
        document.write('Quantidade de alunos com menor nota na prova ', i, '= ', vet[i], '<br>')
    }
}
