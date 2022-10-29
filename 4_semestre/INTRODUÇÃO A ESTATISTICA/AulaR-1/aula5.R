#Estimativas de Minimos Qudadrados 1
##Hidrocarboneto x Pureza
x = c(0.99,1.02,1.15,1.29,1.46,1.36,0.87,1.23,1.55,1.40,1.19,1.15,0.98,1.10,1.11,1.20,1.26,1.32,1.43,0.95)
y = c(90.01,86.05,91.43,93.74,96.73,94.45,87.59,91.77,99.42,93.65,93.54,92.52,90.56,89.54,87.85,90.39,93.25,93.41,94.98,87.33)

#Modelo Linear
Sxx = sum(x * y) - (sum(y) * sum(x))/length(x)
Sxx

Syy = sum(x^2) - ((sum(x))^2)/length(x)
Syy

beta_1 = Sxx/Syy
beta_1

beta_0 = mean(y) - beta_1 * mean(x)
beta_0

paste("y = ", beta_0, " + ", beta_1, "x")

#Soma dos quadrados dos residuos - SQE
SQE = sum((y - beta_0 - beta_1 * x)^2)
SQE

#Estimativa da variancia dos erros
sigma_E = SQE/(length(x) -2)
sigma_E

#Soma dos quadrados da regressao - SQR
SQR = sum((beta_0 + beta_1 * x - mean(y))^2)
SQR

#Soma total dos quadrados - SQT
SQT = sum((y - mean(y))^2)
SQT

#tabela de analise de variancia
options(digits = 4)
Fonte = c("Regressao" , "Residuos", "Total")
GL = c(1, length(x)-2 ,length(x)-1)
SQ = c(SQR,SQE,SQT)
SQM = c(SQR/1, SQE/(length(x)-1), SQT/(length(x) - 1))
F_calc = c((SQR/1)/(SQE/(length(x)-2)),NA,NA)

tab_anova = data.frame(Fonte, GL, SQ, SQM, F_calc)
tab_anova

#Teste de hipotese
#p - significancia
#df1 - grau de liberdade da regressao
#df2 - grau de liberdade da amostra
F_tab_5 = qf(0.05,1,(length(x)-2), lower.tail = F)
F_tab_5

F_tab_10 = qf(0.1,1,(length(x)-2), lower.tail = F)
F_tab_10

#Decisao - 5% de sognificancia - 95% de confiança
ifelse(F_calc[1] < F_tab_5, "Não Rejeita HO", "Rejeita HO")

#Decisao - 10% de sognificancia - 90% de confiança
ifelse(F_calc[1] < F_tab_10, "Não Rejeita HO", "Rejeita HO")
