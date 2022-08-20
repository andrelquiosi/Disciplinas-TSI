x <- c(105,221,181,186,121,181,180,143)
x

#SOMAR OS NUMEROS
x_sum <- sum(x)
x_sum

#TAMANHO DO VETOR
x_len <- length(x)
x_len

#MEDIA
x_med <- x_sum/x_len
x_med

x_med <- mean(x)
x_med

#MEDIANA
x_mediana <- median(x)
x_mediana

#MODA
x_tabela <- as.matrix(table(x))
x_mod <- subset(x_tabela, x_tabela[ ,1] == max(x_tabela[,1]))
x_mod

#VARIÂNCIA
x_var <- var(x)
x_var

#DESVIO PADRÃO
x_sd <- sd(x)
x_sd

x_sd2 <- sqrt(x)
x_sd2

#COEFICIENTE DE VARIAÇÃO
x_cv <- sd(x)/mean(x)*100
x_cv