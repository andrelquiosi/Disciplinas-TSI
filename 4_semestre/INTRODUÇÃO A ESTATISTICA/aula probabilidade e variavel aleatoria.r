############Exercicios - Distribuição uniforme
f = function(x) {1/2}
integrate(Vectorize(f), lower=1, upper=1.5)

#exercicio - Determinar a probabilidade de um ponto escolhido aleatoriamente no intervalo [3,5]. Calcular a Esperança e variância, nesse intervalo.
#Solução:

f = function(x) {1/2}
integrate(Vectorize(f), lower=3, upper=5)

esperanca = 1/(3+2)
esperanca

variancia = ((5-3)²) / 12
variancia

# exercicio - distribuição exponencial
f = function(x) {25*exp(1)^(-25*x)}
integrate(f, lower=0.1, upper=Inf)

# exercicio - distribuição normal

med = 100
sigma = 5
f = function(x) {1/(sigma*sqrt(2*pi))*exp(1)^(-1/2*((x - med)/sigma)^2)}

integrate(f, lower=1, upper=2)

integrate(f, lower=100, upper=106)

integrate(f, lower=89, upper=107)
