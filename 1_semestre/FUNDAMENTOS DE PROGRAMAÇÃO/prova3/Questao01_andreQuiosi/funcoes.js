function preencherVetor(n) {
    var vet = [];
    for (var i = 0; i < n; i++) {
        vet[i] = parseInt(prompt("Informe o Valor"));
    }
    return vet;
}

function vetorPositivos(n,vetor) {
    var vet = [];
    document.write("Os Numeros positivos no vetor são: <br>");
    for (var i = 0; i < n; i++) {
        if (vetor[i] >= 0) {
            vet[i]=vetor[i];
            document.write(vet[i], "<br>")
        }
    }
}

function vetorNegativos(n,vetor) {
    var vet = [];
    document.write("Os Numeros negativos no vetor são: <br>");
    for (var i = 0; i < n; i++) {
        if (vetor[i] < 0) {
            vet[i]=vetor[i];
            document.write(vet[i], "<br>")
        }
    }
}

