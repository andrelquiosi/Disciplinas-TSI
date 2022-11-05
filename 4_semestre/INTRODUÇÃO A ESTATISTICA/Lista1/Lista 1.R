#### QUESTÃO 1
# MEDIA
x <- c(
  10, 94, 32, 19, 55, 35, 20, 48, 68, 24, 18, 83, 30,
  62, 85, 50, 20, 90, 60, 14, 92, 20, 15, 58, 75, 16, 48, 81, 79, 46
)

x_sum <- sum(x)
x_len <- length(x)
c(x_sum, x_len)
x_med <- x_sum / x_len
x_med

# MEDIANA
x_mediana <- median(x)
x_mediana

# MODA
x_tab <- as.matrix(table(x))
x_mod <- subset(x_tab, x_tab[, 1] == max(x_tab[, 1]))
x_mod

#----------------------------------------------------------
# QUESTÃO 2

# VARIÂNCIA
x_var <- var(x)
x_var

# DESVIO PADRÃO
x_sd <- sd(x)
x_sd

# COEFICIENTE DE VARIAÇÃO
x_cv <- sd(x) / mean(x) * 100
x_cv
#----------------------------------------------------------
# QUESTÃO3

# QUARTIS
x_qua <- quantile(x)
x_qua

# AMPLITUDE INTERQUARTÍLICA
quantile(x)[4] - quantile(x)[2]

# LIMITE INFERIOR(LI)
x_li <- quantile(x)[2] - 1.5 * (quantile(x)[4] - quantile(x)[2])
x_li <- as.numeric(x_li)
x_li

# LIMITE SUPERIOR(LS)
x_ls <- quantile(x)[4] + 1.5 * (quantile(x)[4] - quantile(x)[2])
x_ls <- as.numeric(x_ls)
x_ls

#----------------------------------------------------------
# QUESTÃO 4

# BOXPLOT
par(mar = c(3, 2, 1, 1))
boxplot(x)

# INTERPRETAÇÃO: O GRÁFICO É SIMÉTRIOCO, PELA MEDIANA
# ESTAR EXATAMENE NO MEIO DO RETANGULO QUE REPRESENTA
# 50% DO CONJUNTO DOS DADOS.
# O CONJUNTO NÃO APRESENTA OUTLIERS.

#----------------------------------------------------------
# QUESTÃO 5

# ASSIMETRIA DE PEARSON
library(moments)
x_as <- skewness(x)
x_as

# INTERPRETAÇÃO: COMO x_as = 0.211297 < 0,
# SEGUE QUE A DISTRIBUIÇÃO É ASSIMÉTRICA POSITIVA (À DIREITA).

#----------------------------------------------------------

# QUESTÃO 6
# TABELA DE FREQUÊNCIAS

d <- c(
  10, 94, 32, 19, 55, 35, 20, 48, 68, 24, 18, 83,
  30, 62, 85, 50, 20, 90, 60, 14, 92, 20, 15, 58, 75, 16, 48, 81, 79, 46
)

# ORDENAR VALORES
d_unico_ordenado <- unique(sort(d))


# Frequencia Absoluta
fa_1 <- length(d[d == 10])
fa_2 <- length(d[d == 14])
fa_3 <- length(d[d == 15])
fa_4 <- length(d[d == 16])
fa_5 <- length(d[d == 18])
fa_6 <- length(d[d == 19])
fa_7 <- length(d[d == 20])
fa_8 <- length(d[d == 24])
fa_9 <- length(d[d == 30])
fa_10 <- length(d[d == 32])
fa_11 <- length(d[d == 35])
fa_12 <- length(d[d == 46])
fa_13 <- length(d[d == 48])
fa_14 <- length(d[d == 50])
fa_15 <- length(d[d == 55])
fa_16 <- length(d[d == 58])
fa_17 <- length(d[d == 60])
fa_18 <- length(d[d == 62])
fa_19 <- length(d[d == 68])
fa_20 <- length(d[d == 75])
fa_21 <- length(d[d == 79])
fa_22 <- length(d[d == 81])
fa_23 <- length(d[d == 83])
fa_24 <- length(d[d == 85])
fa_25 <- length(d[d == 90])
fa_26 <- length(d[d == 92])
fa_27 <- length(d[d == 94])

col_1 <- c(
  fa_1, fa_2, fa_3, fa_4, fa_5, fa_6, fa_7, fa_8, fa_9, fa_10,
  fa_11, fa_12, fa_13, fa_14, fa_15, fa_16, fa_17, fa_18, fa_19,
  fa_20, fa_21, fa_22, fa_23, fa_24, fa_25, fa_26, fa_27
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

col_2 <- c(
  Fa_1, Fa_2, Fa_3, Fa_4, Fa_5, Fa_6, Fa_7, Fa_8, Fa_9, Fa_10,
  Fa_11, Fa_12, Fa_13, Fa_14, Fa_15, Fa_16, Fa_17, Fa_18, Fa_19,
  Fa_20, Fa_21, Fa_22, Fa_23, Fa_24, Fa_25, Fa_26, Fa_27
)

# Frequencia Relativa
options(digits = 3)
fr_1 <- fa_1 / (length(d))
fr_2 <- fa_2 / (length(d))
fr_3 <- fa_3 / (length(d))
fr_4 <- fa_4 / (length(d))
fr_5 <- fa_5 / (length(d))
fr_6 <- fa_6 / (length(d))
fr_7 <- fa_7 / (length(d))
fr_8 <- fa_8 / (length(d))
fr_9 <- fa_9 / (length(d))
fr_10 <- fa_10 / (length(d))
fr_11 <- fa_11 / (length(d))
fr_12 <- fa_12 / (length(d))
fr_13 <- fa_13 / (length(d))
fr_14 <- fa_14 / (length(d))
fr_15 <- fa_15 / (length(d))
fr_16 <- fa_16 / (length(d))
fr_17 <- fa_17 / (length(d))
fr_18 <- fa_18 / (length(d))
fr_19 <- fa_19 / (length(d))
fr_20 <- fa_20 / (length(d))
fr_21 <- fa_21 / (length(d))
fr_22 <- fa_22 / (length(d))
fr_23 <- fa_23 / (length(d))
fr_24 <- fa_24 / (length(d))
fr_25 <- fa_25 / (length(d))
fr_26 <- fa_26 / (length(d))
fr_27 <- fa_27 / (length(d))

col_3 <- c(
  fr_1, fr_2, fr_3, fr_4, fr_5, fr_6, fr_7, fr_8, fr_9, fr_10,
  fr_11, fr_12, fr_13, fr_14, fr_15, fr_16, fr_17, fr_18, fr_19,
  fr_20, fr_21, fr_22, fr_23, fr_24, fr_25, fr_26, fr_27
)

# Frequencia Relativa Acumulada
options(digits = 3)
Fr_1 <- Fa_1 / (length(d))
Fr_2 <- Fa_2 / (length(d))
Fr_3 <- Fa_3 / (length(d))
Fr_4 <- Fa_4 / (length(d))
Fr_5 <- Fa_5 / (length(d))
Fr_6 <- Fa_6 / (length(d))
Fr_7 <- Fa_7 / (length(d))
Fr_8 <- Fa_8 / (length(d))
Fr_9 <- Fa_9 / (length(d))
Fr_10 <- Fa_10 / (length(d))
Fr_11 <- Fa_11 / (length(d))
Fr_12 <- Fa_12 / (length(d))
Fr_13 <- Fa_13 / (length(d))
Fr_14 <- Fa_14 / (length(d))
Fr_15 <- Fa_15 / (length(d))
Fr_16 <- Fa_16 / (length(d))
Fr_17 <- Fa_17 / (length(d))
Fr_18 <- Fa_18 / (length(d))
Fr_19 <- Fa_19 / (length(d))
Fr_20 <- Fa_20 / (length(d))
Fr_21 <- Fa_21 / (length(d))
Fr_22 <- Fa_22 / (length(d))
Fr_23 <- Fa_23 / (length(d))
Fr_24 <- Fa_24 / (length(d))
Fr_25 <- Fa_25 / (length(d))
Fr_26 <- Fa_26 / (length(d))
Fr_27 <- Fa_27 / (length(d))

col_4 <- c(
  Fr_1, Fr_2, Fr_3, Fr_4, Fr_5, Fr_6, Fr_7, Fr_8, Fr_9, Fr_10,
  Fr_11, Fr_12, Fr_13, Fr_14, Fr_15, Fr_16, Fr_17, Fr_18, Fr_19,
  Fr_20, Fr_21, Fr_22, Fr_23, Fr_24, Fr_25, Fr_26, Fr_27
)

# Frequencia Percentual
options(digits = 3)
fp_1 <- fa_1 / (length(d)) * 100
fp_2 <- fa_2 / (length(d)) * 100
fp_3 <- fa_3 / (length(d)) * 100
fp_4 <- fa_4 / (length(d)) * 100
fp_5 <- fa_5 / (length(d)) * 100
fp_6 <- fa_6 / (length(d)) * 100
fp_7 <- fa_7 / (length(d)) * 100
fp_8 <- fa_8 / (length(d)) * 100
fp_9 <- fa_9 / (length(d)) * 100
fp_10 <- fa_10 / (length(d)) * 100
fp_11 <- fa_11 / (length(d)) * 100
fp_12 <- fa_12 / (length(d)) * 100
fp_13 <- fa_13 / (length(d)) * 100
fp_14 <- fa_14 / (length(d)) * 100
fp_15 <- fa_15 / (length(d)) * 100
fp_16 <- fa_16 / (length(d)) * 100
fp_17 <- fa_17 / (length(d)) * 100
fp_18 <- fa_18 / (length(d)) * 100
fp_19 <- fa_19 / (length(d)) * 100
fp_20 <- fa_20 / (length(d)) * 100
fp_21 <- fa_21 / (length(d)) * 100
fp_22 <- fa_22 / (length(d)) * 100
fp_23 <- fa_23 / (length(d)) * 100
fp_24 <- fa_24 / (length(d)) * 100
fp_25 <- fa_25 / (length(d)) * 100
fp_26 <- fa_26 / (length(d)) * 100
fp_27 <- fa_27 / (length(d)) * 100

col_5 <- c(
  fp_1, fp_2, fp_3, fp_4, fp_5, fp_6, fp_7, fp_8, fp_9, fp_10,
  fp_11, fp_12, fp_13, fp_14, fp_15, fp_16, fp_17, fp_18, fp_19,
  fp_20, fp_21, fp_22, fp_23, fp_24, fp_25, fp_26, fp_27
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

col_6 <- c(
  Fp_1, Fp_2, Fp_3, Fp_4, Fp_5, Fp_6, Fp_7, Fp_8, Fp_9, Fp_10,
  Fp_11, Fp_12, Fp_13, Fp_14, Fp_15, Fp_16, Fp_17, Fp_18, Fp_19,
  Fp_20, Fp_21, Fp_22, Fp_23, Fp_24, Fp_25, Fp_26, Fp_27
)

# TABELA DE FREQUENCIAS
tabela <- data.frame(col_1, col_2, col_3, col_4, col_5, col_6)
colnames(tabela) <- c("fa", "Fa", "fr", "Fr", "fp", "Fp")
tabela
#--------------------------------------------------------------

# QUESTAO 6
# HISTOGRAMA

par(mar = c(3, 2, 1, 1))
fa <- col_1

# ORDENAR VALORES
d_unico_ordenado <- unique(sort(d))
jpeg("histograma.jpg", width = 350, height = 350)
freq <- cbind(d_unico_ordenado, fa)
suppressWarnings(suppressMessages(library("arm")))
discrete.histogram(d, freq = TRUE, xlab = "", bar.width = 0.8)
lines(freq, type = "b", lwd = 3)
dev.off()
# INTERPRETAÇÃO: O GRÁFICO MOSTRA QUE DOIS VALORES SE
# DESTACAM COMO MAIS FREQUENTES, UM COM FREQUENCIA 3 E OUTRO 2,
# SENDO OS OUTROS VALORES COM IGUAL FREQUENCIA E NÃO TENDO OUTLIERS.