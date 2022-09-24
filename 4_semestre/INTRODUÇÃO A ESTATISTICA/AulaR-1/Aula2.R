d <- c(5, 9, 18, 5, 9, 18, 5, 9, 18, 5,
       9, 18, 2, 9, 22, 2, 9, 22, 2, 13,
       22, 1, 13, 18, 1, 13, 9)
par(mar = c(3,2,1,1))

#gráfico Frequencia Absoluta histograma
valor <- unique(sort(d))
fa_1 <- length(d[d == 1])
fa_2 <- length(d[d == 2])
fa_3 <- length(d[d == 5])
fa_4 <- length(d[d == 9])
fa_5 <- length(d[d == 13])
fa_6 <- length(d[d == 18])
fa_7 <- length(d[d == 22])
fa <- c(fa_1, fa_2, fa_3, fa_4, fa_5, fa_6, fa_7)
freq <- cbind(valor, fa)

discrete.histogram(d, freq = TRUE, xlab = "", bar.width = 0.8)
lines(freq, type = "b", lwd=3)

#Grafico Frequencia Absoluta acumuladas histograma


Fa = cumsum(fa)
discrete.histogram(valor,Fa, freq = TRUE, xlab = "", bar.width = 0.8)
freq <- cbind(valor, Fa)
lines(freq, type = "b", lwd=3)



# histograna de dados continuos
d <- c(13.9, 27.3, 16.5, 21.0, 21.9, 15.2, 7.7, 12.4, 19.3,
       15.3, 18.6, 26.5, 16.3, 16.5, 16.8, 12.6, 16.1, 19.5,
       19.1, 18.1, 20.9, 18.1, 11.9, 16.0, 17.3, 12.3, 13.1,
       15.0, 20.2, 15.4)

info_hist = hist(d, main = "Histograma", cex.axis=0.75)
hist(d)
lines(info_hist$mids, info_hist$counts, type = "b")

################

info_hist$breaks = c(7.7, 11.62, 15.54, 19.46, 23.38, 27.30)
info_hist$counts = c(1, 10, 12, 5, 2)
info_hist$mids = c(9.66,13.58,17.5,21.42,25.38)

plot(info_hist, axes = F,main = "Histograma - Ajuste", col = "gray")
axis(side = 1, at=seq(min(d), max(d), length.out =6),cex.axis=0.75)
axis(side = 2, at=seq(0,12,by=2),cex.axis=0.75)
lines(info_hist$mids, info_hist$counts, type = "b")

################

info_hist$counts = cumsum(info_hist$counts)
plot(info_hist, axes = T,main = "Histograma - Frequencia absoluta acumulada", col = "gray")
lines(info_hist$mids, info_hist$counts, type = "b")





