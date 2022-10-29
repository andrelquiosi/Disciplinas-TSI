# tamanho da amostra I
options(digits = 6)

sigma <- 0.4
e <- 0.1
alpha <- 5 / 100
Z_alpha <- qnorm(alpha / 2, mean = 0, sd = 1, lower.tail = FALSE)
n <- (sigma^2 * Z_alpha^2) / e^2
n

round(n)


n_normal <- function(sigma, e, alpha) {
  Z_alpha <- qnorm(alpha / 2, mean = 0, sd = 1, lower.tail = FALSE)
  n <- (sigma^2 * Z_alpha^2) / e^2
  n
  round(n)
}

n_normal(0.4, 0.1, 5 / 100)


# tamanho de amostra II

n_propor <- function(cf, ct, e, alpha) {
  p <- cf / ct
  q <- 1 - p
  Z_alpha <- qnorm(alpha / 2, mean = 0, sd = 1, lower.tail = FALSE)
  n <- (p * q * Z_alpha^2) / e^2
  round(n)
}

n_propor(300, 452, 2 / 100, 5 / 100)


# tamanho de amostra III

n_normal_finita <- function(N, sigma, e, alpha) {
  Z_alpha <- qnorm(alpha / 2, mean = 0, sd = 1, lower.tail = FALSE)
  n <- 1 / (e^2 / (Z_alpha^2 * sigma^2) + 1 / N)
  n
  round(n)
}

n_normal_finita(60, 0.4, 0.1, 5 / 100)


##### amostragem simples aleatórios######

N <- 60
n <- 10
simples_casual_1 <- round(runif(n, min = 1, max = N))
simples_casual_1


##### amostragem aleatórios por extrato######
Ne1 <- 210
Ne2 <- 50
Ne3 <- 40
N <- Ne1 + Ne2 + Ne3
n <- 60
# proporção dos extratos
W1 <- Ne1 / N
W2 <- Ne2 / N
W3 <- Ne3 / N
# tamanho da amostra por extrato
n1 <- W1 * n
n2 <- W2 * n
n3 <- W3 * n
c(n1, n2, n3)

#### Como uma função - para 3 extratos#####
amostra3estratos <- function(n, Ne1, Ne2, Ne3) {
  N <- Ne1 + Ne2 + Ne3
  n <- 60
  W1 <- Ne1 / N
  W2 <- Ne2 / N
  W3 <- Ne3 / N
  n1 <- W1 * n
  n2 <- W2 * n
  n3 <- W3 * n
  round(c(n1, n2, n3))
}

amostra3estratos(60, 210, 50, 40)

##### amostragem sistemática######
amostras_sistematicas <- function(N, n, a) {
  k <- floor(N / n)
  seq(from = a, to = a + (n - 1) * k, by = k)
}

amostras_sistematicas(90, 25, 2)[16:15]
