x <- c(105, 221, 181, 186, 121, 181, 180, 143)
x

#SOMAR OS NUMEROS
x_sum <- sum(x)
x_sum

#TAMANHO DO VETOR
x_len <- length(x)
x_len

#MEDIA
x_med <- x_sum / x_len
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

# QUATIS
x <- c(3,4,6,8,11,14,16,17,20,21,23,24)
x_qua <- quantile(x)
x_qua

#quati limite superior e limite inferior
x_LI <- quantile(x)[2] - 1.5*(quantile(x)[4] - quantile(x)[2])
x_LI <- as.numeric(x_LI)
x_LI

x_LS <- quantile(x)[4] + 1.5*(quantile(x)[4] - quantile(x)[2])
x_LS <- as.numeric(x_LS)
x_LS

# boxplot quati
par(mar = c(3,2,1,1))
boxplot(x)

#Coeficiente de asimetria
library(moments)
x_as <-skewness(x)
x_as

#Coeficiente de curtose
x_k <- kurtosis(x)
x_k


#Tabela de distribuoção de frequencia#####################################
d <- c(5,9,18,5,9,18,5,9,18,5,9,18,2,9,22,2,9,22,2,13,22,1,13,18,1,13,9)
d_ordenado<- sort(d)
d_ordenado[1:15]; d_ordenado[16:27]
#######Frequencia absoluta

fa1 <- length(d[d == 1])
fa2 <- length(d[d == 2])
fa3 <- length(d[d == 5])
fa4 <- length(d[d == 9])
fa5 <- length(d[d == 13])
fa6 <- length(d[d == 18])
fa7 <- length(d[d == 22])

c(fa1,fa2,fa3,fa4,fa5,fa6,fa7)


########frequencia absoluta acumulada

Fa1 = fa1
Fa2 =Fa1+fa2
Fa3=Fa2+fa3
Fa4=Fa3+fa4
Fa5=Fa4+fa5
Fa6=Fa5+fa6
Fa7=Fa6+fa7
c(Fa1,Fa2,Fa3,Fa4,Fa5,Fa6,Fa7)

#######frequencia relativa

options(digits=3)
fr1 = fa1/length(d)
fr2 = fa2/length(d)
fr3 = fa3/length(d)
fr4 = fa4/length(d)
fr5 = fa5/length(d)
fr6 = fa6/length(d)
fr7 = fa7/length(d)

c(fr1,fr2,fr3,fr4,fr5,fr6,fr7)

########Frequencia relativa acumulada

options(digits=3)
Fr1 = Fa1/length(d)
Fr2 = Fa2/length(d)
Fr3 = Fa3/length(d)
Fr4 = Fa4/length(d)
Fr5 = Fa5/length(d)
Fr6 = Fa6/length(d)
Fr7 = Fa7/length(d)

c(Fr1,Fr2,Fr3,Fr4,Fr5,Fr6,Fr7)

#######frequencia Percentual

options(digits=3)
fp1 = fa1/length(d)*100
fp2 = fa2/length(d)*100
fp3 = fa3/length(d)*100
fp4 = fa4/length(d)*100
fp5 = fa5/length(d)*100
fp6 = fa6/length(d)*100
fp7 = fa7/length(d)*100


c(fp1,fp2,fp3,fp4,fp5,fp6,fp7)

########frequencia percentual acumulada

Fp1=fp1
Fp2=Fp1+fp2
Fp3=Fp2+fp3
Fp4=Fp3+fp4
Fp5=Fp4+fp5
Fp6=Fp5+fp6
Fp7=Fp6+fp7
c(Fp1,Fp2,Fp3,Fp4,Fp5,Fp6,Fp7)

#######Criando a tabela

col1 =c(fa1,fa2,fa3,fa4,fa5,fa6,fa7)
col2 =c(Fa1,Fa2,Fa3,Fa4,Fa5,Fa6,Fa7)
col3 =c(fr1,fr2,fr3,fr4,fr5,fr6,fr7)
col4 =c(Fr1,Fr2,Fr3,Fr4,Fr5,Fr6,Fr7)
col5 =c(fp1,fp2,fp3,fp4,fp5,fp6,fp7)
col6 =c(Fp1,Fp2,Fp3,Fp4,Fp5,Fp6,Fp7)

tabela = data.frame(col1,col2,col3,col4,col5,col6)
colnames(tabela) = c('fa','Fa','fr','fr','fp','Fp')
tabela

#Tabela de frequencia com valores contínuos

d = c(13.9, 27.3, 16.5, 21.0, 21.9, 15.2, 7.7, 12.4, 19.3, 15.3,
      18.6, 26.5, 16.3, 16.5, 16.8, 12.6, 16.1, 19.5, 19.1, 18.1,
      20.9, 18.1, 11.9, 16.0, 17.3, 12.3, 13.1, 15.0, 20.2, 15.4)

d_ordenado = sort(d)
A_t = max(d) - min(d)
A_t
###numero de classes
k = round(sqrt(length(d)))
k
###Amplitude das classes
A_c = A_t/k
A_c
####Limite inferir e Superior das Classes
C1_inf = min(d)
C1_sup = C1_inf + A_c
c(C1_inf, C1_sup)

C2_inf = C1_sup
C2_sup = C2_inf + A_c
c(C2_inf, C2_sup)

C3_inf = C2_sup
C3_sup = C3_inf + A_c
c(C3_inf, C3_sup)

C4_inf = C3_sup
C4_sup = C4_inf + A_c
c(C4_inf, C4_sup)

C5_inf = C4_sup
C5_sup = C5_inf + A_c
c(C5_inf, C5_sup)

####Ponto médio das classes
C1_Medio = (C1_inf + C1_sup)/2
C2_Medio = (C2_inf + C2_sup)/2
C3_Medio = (C3_inf + C3_sup)/2
C4_Medio = (C4_inf + C4_sup)/2
C5_Medio = (C5_inf + C5_sup)/2

c(C1_Medio,C2_Medio,C3_Medio,C4_Medio,C5_Medio)

###Frequencia absoluta
C1_fa = length(d[d >= C1_inf & d < C1_sup])
C2_fa = length(d[d >= C2_inf & d < C2_sup])
C3_fa = length(d[d >= C3_inf & d < C3_sup])
C4_fa = length(d[d >= C4_inf & d < C4_sup])
C5_fa = length(d[d >= C5_inf & d < C5_sup])

c(C1_fa,C2_fa,C3_fa,C4_fa,C5_fa)

###Frequencia absoluta acumulada
C1_Fa = C1_fa
C2_Fa = C1_Fa + C2_fa
C3_Fa = C2_Fa + C3_fa
C4_Fa = C3_Fa + C4_fa
C5_Fa = C4_Fa + C5_fa

c(C1_Fa,C2_Fa,C3_Fa,C4_Fa,C5_Fa)

#####Frequencia relativa

options(digits=3)
C1fr = C1_Fa/length(d)
C2fr = C2_Fa/length(d)
C3fr = C3_Fa/length(d)
C4fr = C4_Fa/length(d)
C5fr = C5_Fa/length(d)


c(C1fr,C2fr,C3fr,C4fr,C5fr)

########Frequencia relativa acumulada

options(digits=3)
C1Fr = C1_Fa/length(d)
C2Fr = C2_Fa/length(d)
C3Fr = C3_Fa/length(d)
C4Fr = C4_Fa/length(d)
C5Fr = C5_Fa/length(d)


c(C5Fr,C2Fr,C3Fr,C4Fr,C5Fr)

#######frequencia Percentual

options(digits=3)
C1fp = C1Fr/length(d)*100
C2fp = C2Fr/length(d)*100
C3fp = C3Fr/length(d)*100
C4fp = C4Fr/length(d)*100
C5fp = C5Fr/length(d)*100



c(C1fp,C2fp,C3fp,C4fp,C5fp)

########frequencia percentual acumulada

CFp1=C1fp
CFp2=CFp1+C2fp
CFp3=CFp2+C3fp
CFp4=CFp3+C4fp
CFp5=CFp4+C5fp

c(CFp1,CFp2,CFp3,CFp4,CFp5)

#######Criando a tabela

col1 =c(C1_fa,C2_fa,C3_fa,C4_fa,C5_fa)
col2 =c(C1_Fa,C2_Fa,C3_Fa,C4_Fa,C5_Fa)
col3 =c(C5Fr,C2Fr,C3Fr,C4Fr,C5Fr)
col4 =c(C1fp,C2fp,C3fp,C4fp,C5fp)
col5 =c(CFp1,CFp2,CFp3,CFp4,CFp5)



tabela = data.frame(col1,col2,col3,col4,col5)
colnames(tabela) = c('fa','Fa','Fr','fp','Fp')
tabela


##########################Grafico histograma

d <- c(5,9,18,5,9,18,5,9,18,5,9,18,2,9,22,2,9,22,2,13,22,1,13,18,1,13,9)
hist(d ,break = 30, main="histograma", ,xlab="",ylab="" )
axis(side=1, at=seq(1,22,by=3))
axis(side=2, at=seq(0,7,by=1))
lines(freq,type="b")


########################Grafico de poligono de frequencia

d <- c(5,9,18,5,9,18,5,9,18,5,9,18,2,9,22,2,9,22,2,13,22,1,13,18,1,13,9)
par(mar = c(3,2,1,1))

valor = unique(sort(d))

fa1 <- length(d[d == 1])
fa2 <- length(d[d ==2])
fa3 <- length(d[d == 5])
fa4 <- length(d[d == 9])
fa5 <- length(d[d == 13])
fa6 <- length(d[d == 18])
fa7 <- length(d[d == 22])

fa = c(fa1,fa2,fa3,fa4,fa5,fa6,fa7) 

freq = cbind(valor,fa)
plot(freq, axes=T,type="b",xlab="",ylab="")
hist(d ,breaks = 30, main="histograma" ,xlab="",ylab="" )
axis(side=1, at=seq(1,22,by=3))
axis(side=2, at=seq(0,7,by=1))
lines(freq,type="b")

