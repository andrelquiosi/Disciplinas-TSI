d = c(8,10,18,7,29,47,44,38,27,15,11,21)

meses = c("janeir", "fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro")

#gráficos de barra vertical

barplot(d,names.arg=meses, ylim=c(0,60),xlab="Mes",ylab = "producao", col="darkgreen",main = "Grafico barras",border = "black")

#grafico de barra vertical com 4 regiões

d = c(12,23,34,45,56,67,78,89,90,21,32,43,
      08,07,06,05,04,03,02,01,78,87,76,65,
      13,14,15,16,17,18,19,10,20,29,28,27,
      38,37,36,35,34,33,22,44,55,66,77,88)
d_matriz = matrix(d, nrow = 4, ncol = 12,byrow = TRUE)

meses = c("janeir", "fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro")
cores = c("blue","orange","darkgreen","brown")
regioes = c("a","b","c","d")

barplot(d_matriz, names.arg=meses, xlab="Mes", ylab = "producao", col=cores, main = "Grafico barras")
legend("toprigth", regioes,cex = 0,7,fill = cores)

#grafico de pizza

d = c(8,10,18,7,29,47,44,38,27,15,11,21)
meses = c("janeir", "fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro")
par(mar = c(0,0,2,0))
pie(d,labels = meses, main="Grafico pizza")





