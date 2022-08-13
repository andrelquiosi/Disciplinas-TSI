function preencherVetor(n) {
    var vet = [];
    for (var i = 0; i < n; i++) {
        vet[i] = Number(prompt("Informe o Valor"));
    }
    return vet;
}

function exibirVetor(n, vet) {
    for (var i = 0; i < n; i++) {
        document.write("Vetor [", i, "]= ", vet[i], "<br>");
    }
}

function somarVetores(n, vetor1, vetor2) {
    var vetSoma = [];
    for (var i = 0; i < n; i++) {
        vetSoma[i] = vetor1[i], vetor2[i];
    }
    return vetSoma;
}

function somaVetor(n, vetor) {
    var somaGeral = 0;
    for (var i = 0; i < n; i++) {
        somaGeral += vetor[i];
    }
    return somaGeral;
}

// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
function nomeProduto(n) { //função que pede e adiciona os nomes e um vetor
    var val = [];
    for (var i = 0; i < n; i++) {
        val[i] = prompt("Informe o Nome do Item " + (i + 1));

    }
    return val;
}


function estoqueProduto(n, nome) { // função que adiciona a quantidade de itens em um vetor
    var val = [];
    for (var i = 0; i < n; i++) {
        val[i] = parseInt(prompt("Informe o Estoque do Item " + nome[i]));

    }
    return val;
}

function valorDosProdutos(n, quantProd, nome) { //função que adiciona valores dos produtos em um vetor
    val = [];
    for (var i = 0; i < n; i++) {
        val[i] = parseInt(prompt("Qual o valor unitário do poduto " + nome[i] + " com " + quantProd[i]));

    }
    return val;
}


function vendaDia(n, nome, quantProd) { //função que adiciona quantidade vendida em um vetor
    val = [];
    for (var i = 0; i < n; i++) {
        val[i] = parseInt(prompt("Qual a quantidade vendida do produto " + nome[i] + " no dia?\n Com estoque de "+ quantProd[i]));

    }
    return val;
}

function relatorio(n, nome, totEstoque, vendaTot, valProd) { //função que retorna o relatorio de venda
    var fat = 0, faturamento=[], totalEst=[];
    for (var i = 0; i < n; i++) {
        document.write("O estoque do produto ", nome[i], " no final do dia é de: ", totEstoque[i] - vendaTot[i], "<br>");

        faturamento[i] = vendaTot[i] * valProd[i];
        fat += faturamento[i];
    }
    document.write("<hr>O faturamento diário geral é de: ", fat.toFixed(2));
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

function organizarCrescente(vet, n){
    for(var i=0; i < n; i++){
        for(var j= i+1; j < n; j++){
            if(vet[i] > vet[j]){
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
            }
        }
    }
    return vet;
}
function organizarDecrescente(vet, n){
    for(var i=0; i < n; i++){
        for(var j= i+1; j < n; j++){
            if(vet[i] < vet[j]){
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
            }
        }
    }
    return vet;
}