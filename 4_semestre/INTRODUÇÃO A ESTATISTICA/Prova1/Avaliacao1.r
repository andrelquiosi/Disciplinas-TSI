# QUESTÃO 1-
x <- c(
    2.0, 8.3, 8.9, 10.0, 10.1, 3.0,
    5.2, 2.7, 2.1, 5.6, 6.4, 3.7, 10.8, 6.8,
    -3.1, 4.9, 4.3, 8.4, 3.3, 3.7, 13.8, 2.7,
    5.8, 3.0, 3.7, 12.1, 5.1, 11.1, 1.9, 3.4,
    6.7, 7.4, 1.8, 5.1, 5.3, 4.7, 4.2, 0.9, 8.5,
    6.7, 10.4, 9.4, 3.5, 6.1, 2.8
)

# (A)-----------------------

# MEDIA
x_med <- mean(x)
x_med

# MEDIANA
x_mediana <- median(x)
x_mediana

# MODA
x_tabela <- as.matrix(table(x))
x_mod <- subset(x_tabela, x_tabela[, 1] == max(x_tabela[, 1]))
x_mod

# (B)-----------------------

# VARIÂNCIA
x_var <- var(x)
x_var

# DESVIO PADRÃO
x_sd <- sd(x)
x_sd

# COEFICIENTE DE VARIAÇÃO
x_cv <- sd(x) / mean(x) * 100
x_cv


# (C)----------------------

# QUARTIS
x_qua <- quantile(x)
x_qua

# AMPLITUDE INTERQUARTIL
x_amp = quantile(x)[4] - quantile(x)[2]
x_amp

# LIMITE INFERIOR(LI)
x_li <- quantile(x)[2] - 1.5 * (quantile(x)[4] - quantile(x)[2])
x_li <- as.numeric(x_li)
x_li

# LIMITE SUPERIOR(LS)
x_ls <- quantile(x)[4] + 1.5 * (quantile(x)[4] - quantile(x)[2])
x_ls <- as.numeric(x_ls)
x_ls

# (D)-------------------------

# BOXPLOT

par(mar = c(3, 2, 1, 1))
jpeg("4_semestre/INTRODUÇÃO A ESTATISTICA/Prova1/boxplot_prova.jpg", width = 350, height = 350)
boxplot(x)
dev.off()

# INTERPRETAÇÃO: O GRÁFICO É ASSIMÉTRICO POSITIVO, PELA MEDIANA
# ESTAR MAIS PROXIMA DO PRIMEIRO QUARTIL.
# APRESENTA TAMBÉM CAUDAS DE DISTRIBUIÇÃO LONGAS.
# O CONJUNTO NÃO APRESENTA OUTLIERS.

# (E)------------------------

# ASSIMETRIA DE PEARSON
library("moments")
x_as <- skewness(x)
x_as

# INTERPRETAÇÃO: COMO x_as = 0.2498484 < 0,
# SEGUE QUE A DISTRIBUIÇÃO É ASSIMÉTRICA POSITIVA (À DIREITA).

# (F)------------------------

# ORDENAR VALORES
d_unico_ordenado <- unique(sort(x))


# Frequencia Absoluta
fa_1 <- length(x[x == -3.1])
fa_2 <- length(x[x == 0.9])
fa_3 <- length(x[x == 1.8])
fa_4 <- length(x[x == 1.9])
fa_5 <- length(x[x == 2.0])
fa_6 <- length(x[x == 2.1])
fa_7 <- length(x[x == 2.7])
fa_8 <- length(x[x == 2.8])
fa_9 <- length(x[x == 3.0])
fa_10 <- length(x[x == 3.3])
fa_11 <- length(x[x == 3.4])
fa_12 <- length(x[x == 3.5])
fa_13 <- length(x[x == 3.7])
fa_14 <- length(x[x == 4.2])
fa_15 <- length(x[x == 4.3])
fa_16 <- length(x[x == 4.7])
fa_17 <- length(x[x == 4.9])
fa_18 <- length(x[x == 5.1])
fa_19 <- length(x[x == 5.2])
fa_20 <- length(x[x == 5.3])
fa_21 <- length(x[x == 5.6])
fa_22 <- length(x[x == 5.8])
fa_23 <- length(x[x == 6.1])
fa_24 <- length(x[x == 6.4])
fa_25 <- length(x[x == 6.7])
fa_26 <- length(x[x == 6.8])
fa_27 <- length(x[x == 7.4])
fa_28 <- length(x[x == 8.3])
fa_29 <- length(x[x == 8.4])
fa_30 <- length(x[x == 8.5])
fa_31 <- length(x[x == 8.9])
fa_32 <- length(x[x == 9.4])
fa_33 <- length(x[x == 10.0])
fa_34 <- length(x[x == 10.1])
fa_35 <- length(x[x == 10.4])
fa_36 <- length(x[x == 10.8])
fa_37 <- length(x[x == 11.1])
fa_38 <- length(x[x == 12.1])
fa_39 <- length(x[x == 13.8])

col_1 <- c(
    fa_1, fa_2, fa_3, fa_4, fa_5, fa_6, fa_7, fa_8, fa_9, fa_10,
    fa_11, fa_12, fa_13, fa_14, fa_15, fa_16, fa_17, fa_18, fa_19,
    fa_20, fa_21, fa_22, fa_23, fa_24, fa_25, fa_26, fa_27, fa_28,
    fa_29, fa_30, fa_31, fa_32, fa_33, fa_34, fa_35, fa_36, fa_37,
    fa_38, fa_39
)

# Frequencia Absoluta Acumulada

Fa_1 <- fa_1
Fa_2 <- Fa_1 + fa_2
Fa_3 <- Fa_2 + fa_3
Fa_4 <- Fa_3 + fa_4
Fa_5 <- Fa_4 + fa_5
Fa_6 <- Fa_5 + fa_6
Fa_7 <- Fa_6 + fa_7
Fa_8 <- Fa_7 + fa_8
Fa_9 <- Fa_8 + fa_9
Fa_10 <- Fa_9 + fa_10
Fa_11 <- Fa_10 + fa_11
Fa_12 <- Fa_11 + fa_12
Fa_13 <- Fa_12 + fa_13
Fa_14 <- Fa_13 + fa_14
Fa_15 <- Fa_14 + fa_15
Fa_16 <- Fa_15 + fa_16
Fa_17 <- Fa_16 + fa_17
Fa_18 <- Fa_17 + fa_18
Fa_19 <- Fa_18 + fa_19
Fa_20 <- Fa_19 + fa_20
Fa_21 <- Fa_20 + fa_21
Fa_22 <- Fa_21 + fa_22
Fa_23 <- Fa_22 + fa_23
Fa_24 <- Fa_23 + fa_24
Fa_25 <- Fa_24 + fa_25
Fa_26 <- Fa_25 + fa_26
Fa_27 <- Fa_26 + fa_27
Fa_28 <- Fa_27 + fa_28
Fa_29 <- Fa_28 + fa_29
Fa_30 <- Fa_29 + fa_30
Fa_31 <- Fa_30 + fa_31
Fa_32 <- Fa_31 + fa_32
Fa_33 <- Fa_32 + fa_33
Fa_34 <- Fa_33 + fa_34
Fa_35 <- Fa_34 + fa_35
Fa_36 <- Fa_35 + fa_36
Fa_37 <- Fa_36 + fa_37
Fa_38 <- Fa_37 + fa_38
Fa_39 <- Fa_38 + fa_39

col_2 <- c(
    Fa_1, Fa_2, Fa_3, Fa_4, Fa_5, Fa_6, Fa_7, Fa_8, Fa_9, Fa_10,
    Fa_11, Fa_12, Fa_13, Fa_14, Fa_15, Fa_16, Fa_17, Fa_18, Fa_19,
    Fa_20, Fa_21, Fa_22, Fa_23, Fa_24, Fa_25, Fa_26, Fa_27, Fa_28,
    Fa_29, Fa_30, Fa_31, Fa_32, Fa_33, Fa_34, Fa_35, Fa_36, Fa_37,
    Fa_38, Fa_39
)

# Frequencia Relativa Acumulada

fr_1 <- length(x)
fr_2 <- length(x)
fr_3 <- length(x)
fr_4 <- length(x)
fr_5 <- length(x)
fr_6 <- length(x)
fr_7 <- length(x)
fr_8 <- length(x)
fr_9 <- length(x)
fr_10 <- length(x)
fr_11 <- length(x)
fr_12 <- length(x)
fr_13 <- length(x)
fr_14 <- length(x)
fr_15 <- length(x)
fr_16 <- length(x)
fr_17 <- length(x)
fr_18 <- length(x)
fr_19 <- length(x)
fr_20 <- length(x)
fr_21 <- length(x)
fr_22 <- length(x)
fr_23 <- length(x)
fr_24 <- length(x)
fr_25 <- length(x)
fr_26 <- length(x)
fr_27 <- length(x)
fr_28 <- length(x)
fr_29 <- length(x)
fr_30 <- length(x)
fr_31 <- length(x)
fr_32 <- length(x)
fr_33 <- length(x)
fr_34 <- length(x)
fr_35 <- length(x)
fr_36 <- length(x)
fr_37 <- length(x)
fr_38 <- length(x)
fr_39 <- length(x)

col_3 <- c(
    fr_1, fr_2, fr_3, fr_4, fr_5, fr_6, fr_7, fr_8, fr_9, fr_10,
    fr_11, fr_12, fr_13, fr_14, fr_15, fr_16, fr_17, fr_18, fr_19,
    fr_20, fr_21, fr_22, fr_23, fr_24, fr_25, fr_26, fr_27, fr_28,
    fr_29, fr_30, fr_31, fr_32, fr_33, fr_34, fr_35, fr_36, fr_37,
    fr_38, fr_39
)

# Frequencia Relativa Acumulada
Fr_1 <- Fa_1 / length(x)
Fr_2 <- Fa_2 / length(x)
Fr_3 <- Fa_3 / length(x)
Fr_4 <- Fa_4 / length(x)
Fr_5 <- Fa_5 / length(x)
Fr_6 <- Fa_6 / length(x)
Fr_7 <- Fa_7 / length(x)
Fr_8 <- Fa_8 / length(x)
Fr_9 <- Fa_9 / length(x)
Fr_10 <- Fa_10 / length(x)
Fr_11 <- Fa_11 / length(x)
Fr_12 <- Fa_12 / length(x)
Fr_13 <- Fa_13 / length(x)
Fr_14 <- Fa_14 / length(x)
Fr_15 <- Fa_15 / length(x)
Fr_16 <- Fa_16 / length(x)
Fr_17 <- Fa_17 / length(x)
Fr_18 <- Fa_18 / length(x)
Fr_19 <- Fa_19 / length(x)
Fr_20 <- Fa_20 / length(x)
Fr_21 <- Fa_21 / length(x)
Fr_22 <- Fa_22 / length(x)
Fr_23 <- Fa_23 / length(x)
Fr_24 <- Fa_24 / length(x)
Fr_25 <- Fa_25 / length(x)
Fr_26 <- Fa_26 / length(x)
Fr_27 <- Fa_27 / length(x)
Fr_28 <- Fa_28 / length(x)
Fr_29 <- Fa_29 / length(x)
Fr_30 <- Fa_30 / length(x)
Fr_31 <- Fa_31 / length(x)
Fr_32 <- Fa_32 / length(x)
Fr_33 <- Fa_33 / length(x)
Fr_34 <- Fa_34 / length(x)
Fr_35 <- Fa_35 / length(x)
Fr_36 <- Fa_36 / length(x)
Fr_37 <- Fa_37 / length(x)
Fr_38 <- Fa_38 / length(x)
Fr_39 <- Fa_39 / length(x)

col_4 <- c(
    Fr_1, Fr_2, Fr_3, Fr_4, Fr_5, Fr_6, Fr_7, Fr_8, Fr_9, Fr_10,
    Fr_11, Fr_12, Fr_13, Fr_14, Fr_15, Fr_16, Fr_17, Fr_18, Fr_19,
    Fr_20, Fr_21, Fr_22, Fr_23, Fr_24, Fr_25, Fr_26, Fr_27, Fr_28,
    Fr_29, Fr_30, Fr_31, Fr_32, Fr_33, Fr_34, Fr_35, Fr_36, Fr_37,
    Fr_38, Fr_39
)

# Frequencia Percentual

fp_1 <- fa_1 / length(x) * 100
fp_2 <- fa_2 / length(x) * 100
fp_3 <- fa_3 / length(x) * 100
fp_4 <- fa_4 / length(x) * 100
fp_5 <- fa_5 / length(x) * 100
fp_6 <- fa_6 / length(x) * 100
fp_7 <- fa_7 / length(x) * 100
fp_8 <- fa_8 / length(x) * 100
fp_9 <- fa_9 / length(x) * 100
fp_10 <- fa_10 / length(x) * 100
fp_11 <- fa_11 / length(x) * 100
fp_12 <- fa_12 / length(x) * 100
fp_13 <- fa_13 / length(x) * 100
fp_14 <- fa_14 / length(x) * 100
fp_15 <- fa_15 / length(x) * 100
fp_16 <- fa_16 / length(x) * 100
fp_17 <- fa_17 / length(x) * 100
fp_18 <- fa_18 / length(x) * 100
fp_19 <- fa_19 / length(x) * 100
fp_20 <- fa_20 / length(x) * 100
fp_21 <- fa_21 / length(x) * 100
fp_22 <- fa_22 / length(x) * 100
fp_23 <- fa_23 / length(x) * 100
fp_24 <- fa_24 / length(x) * 100
fp_25 <- fa_25 / length(x) * 100
fp_26 <- fa_26 / length(x) * 100
fp_27 <- fa_27 / length(x) * 100
fp_28 <- fa_28 / length(x) * 100
fp_29 <- fa_29 / length(x) * 100
fp_30 <- fa_30 / length(x) * 100
fp_31 <- fa_31 / length(x) * 100
fp_32 <- fa_32 / length(x) * 100
fp_33 <- fa_33 / length(x) * 100
fp_34 <- fa_34 / length(x) * 100
fp_35 <- fa_35 / length(x) * 100
fp_36 <- fa_36 / length(x) * 100
fp_37 <- fa_37 / length(x) * 100
fp_38 <- fa_38 / length(x) * 100
fp_39 <- fa_39 / length(x) * 100

col_5 <- c(
    fp_1, fp_2, fp_3, fp_4, fp_5, fp_6, fp_7, fp_8, fp_9, fp_10,
    fp_11, fp_12, fp_13, fp_14, fp_15, fp_16, fp_17, fp_18, fp_19,
    fp_20, fp_21, fp_22, fp_23, fp_24, fp_25, fp_26, fp_27, fp_28,
    fp_29, fp_30, fp_31, fp_32, fp_33, fp_34, fp_35, fp_36, fp_37,
    fp_38, fp_39
)

# Frequencia Percentual Acumulada
Fp_1 <- fp_1
Fp_2 <- Fp_1 + fp_2
Fp_3 <- Fp_2 + fp_3
Fp_4 <- Fp_3 + fp_4
Fp_5 <- Fp_4 + fp_5
Fp_6 <- Fp_5 + fp_6
Fp_7 <- Fp_6 + fp_7
Fp_8 <- Fp_7 + fp_8
Fp_9 <- Fp_8 + fp_9
Fp_10 <- Fp_9 + fp_10
Fp_11 <- Fp_10 + fp_11
Fp_12 <- Fp_11 + fp_12
Fp_13 <- Fp_12 + fp_13
Fp_14 <- Fp_13 + fp_14
Fp_15 <- Fp_14 + fp_15
Fp_16 <- Fp_15 + fp_16
Fp_17 <- Fp_16 + fp_17
Fp_18 <- Fp_17 + fp_18
Fp_19 <- Fp_18 + fp_19
Fp_20 <- Fp_19 + fp_20
Fp_21 <- Fp_20 + fp_21
Fp_22 <- Fp_21 + fp_22
Fp_23 <- Fp_22 + fp_23
Fp_24 <- Fp_23 + fp_24
Fp_25 <- Fp_24 + fp_25
Fp_26 <- Fp_25 + fp_26
Fp_27 <- Fp_26 + fp_27
Fp_28 <- Fp_27 + fp_28
Fp_29 <- Fp_28 + fp_29
Fp_30 <- Fp_29 + fp_30
Fp_31 <- Fp_30 + fp_31
Fp_32 <- Fp_31 + fp_32
Fp_33 <- Fp_32 + fp_33
Fp_34 <- Fp_33 + fp_34
Fp_35 <- Fp_34 + fp_35
Fp_36 <- Fp_35 + fp_36
Fp_37 <- Fp_36 + fp_37
Fp_38 <- Fp_37 + fp_38
Fp_39 <- Fp_38 + fp_39

col_6 <- c(
    Fp_1, Fp_2, Fp_3, Fp_4, Fp_5, Fp_6, Fp_7, Fp_8, Fp_9, Fp_10,
    Fp_11, Fp_12, Fp_13, Fp_14, Fp_15, Fp_16, Fp_17, Fp_18, Fp_19,
    Fp_20, Fp_21, Fp_22, Fp_23, Fp_24, Fp_25, Fp_26, Fp_27, Fp_28,
    Fp_29, Fp_30, Fp_31, Fp_32, Fp_33, Fp_34, Fp_35, Fp_36, Fp_37,
    Fp_38, Fp_39
)

# TABELA DE FREQUENCIAS
tabela <- data.frame(col_1, col_2, col_3, col_4, col_5, col_6)
colnames(tabela) <- c("fa", "Fa", "fr", "Fr", "fp", "Fp")
tabela

# (G)-----------------------

# HISTOGRAMA
par(mar = c(3, 2, 1, 1))
fa <- col_1

# ORDENAR VALORES
jpeg("4_semestre/INTRODUÇÃO A ESTATISTICA/Prova1/histograma_prova.jpg", width = 800, height = 800)
d_unico_ordenado <- unique(sort(x))
freq <- cbind(d_unico_ordenado, fa)
suppressWarnings(suppressMessages(library("arm")))
discrete.histogram(x, freq = TRUE, xlab = "", bar.width = 0.8)
lines(freq, type = "b", lwd = 3)
dev.off()

# INTERPRETAÇÃO: O GRÁFICO MOSTRA QUE CINCO VALORES SE
# DESTACAM COMO MAIS FREQUENTES, UM COM FREQUENCIA 3 E OUTROS 2,
# SENDO OS OUTROS VALORES COM IGUAL FREQUENCIA PORÉM CONTEM OUTLIERS.

# QUESTÃO 2

amostra4estratos <- function(n, Ne1, Ne2, Ne3, Ne4) {
    # Tamanho da populacao e amostra
    N <- Ne1 + Ne2 + Ne3 + Ne4
    n <- n
    # Proporcao dos estratos
    W1 <- Ne1 / N
    W2 <- Ne2 / N
    W3 <- Ne3 / N
    W4 <- Ne4 / N
    # Tamanho da amostra por estrato
    n1 <- W1 * n
    n2 <- W2 * n
    n3 <- W3 * n
    n4 <- W4 * n
    round(c(n1, n2, n3, n4))
}
amostra4estratos(25, 12, 22, 7, 29)
