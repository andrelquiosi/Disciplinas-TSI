#Questão 1
#A)
h = c(2,7,2,1,1,1,15)
n = c(18,60,20,14,15,16,82)

rho_hn <- sum((h - mean(h)) * (n - mean(h)))/(sqrt(sum((h - mean(h))^2)) * sqrt(sum((n - mean(n))^2)))
rho_hn

#resultado [1] 0.9747042
# interpretação 
    # 0,9 a 1,0 positivo ou negativo, se tem uma correlação muito forte;

#B)
x = c(2,7,2,1,1,1,15)
y = c(18,60,20,14,15,16,82)
dados <- data.frame(x,y)
dados

modelo.regressao <- lm(y ~ x, data= dados)
summary(modelo.regressao)

anova(modelo.regressao)

plot (y ~ x,pch=16 ,data = dados)
abline(modelo.regressao,col="red")

#C)
x = c(2,7,2,1,1,1,15)
y = c(18,60,20,14,15,16,82)

#Modelo Linear
Sxx <- sum(x * y) - (sum(y) * sum(x))/length(x)
Syy <- sum(x^2) - ((sum(x))^2)/length(x)
beta_1 <- Sxx/Syy
beta_0 <- mean(y) - beta_1 * mean(x)

#Soma dos quadrados da regressao - SQR
SQR <- sum((beta_0 + beta_1*x - mean(y))^2)
SQR
## [1] 4268.431
#Soma total dos quadrados - SQT
SQT <- sum((y - mean(y))^2)
SQT
## [1] 4492.857
#Coeficiente de determinacao
R2 <- SQR/SQT
R2

## [1] 0.9500482

#Questão 2
#  I.C. com 90%
options(digits=4)
n <- 650; x <- 240; p <- x/n; alpha <- 0.1
Z_alpha1 <- qnorm(alpha/2, mean = 0, sd = 1, lower.tail = FALSE)
IC <- c(p - Z_alpha1*sqrt(p*(1 - p)/n),
p + Z_alpha1*sqrt(p*(1 - p)/n))
IC
# [1] 0.3381 0.4004

#  I.C. com 95%
options(digits=4)
n <- 650; x <- 240; p <- x/n; alpha <- 0.05
Z_alpha1 <- qnorm(alpha/2, mean = 0, sd = 1, lower.tail = FALSE)
IC <- c(p - Z_alpha1*sqrt(p*(1 - p)/n),
p + Z_alpha1*sqrt(p*(1 - p)/n))
IC
# [1] 0.3321 0.4063

# Questão 3
# IC com 90%
options(digits=8)
x_med <- 450; sigma <- 7; alpha<-0.10; n <- 90
Z_alpha5 <- qnorm(alpha/2, mean = 0, sd = 1, lower.tail = FALSE)
IC <- c(x_med - Z_alpha5*sigma/sqrt(n),
x_med + Z_alpha5*sigma/sqrt(n))
IC
## [1] 448.78632 451.21368

# IC com 95%
options(digits=8)
x_med <- 450; sigma <- 7; alpha<-0.05; n <- 90
Z_alpha10 <- qnorm(alpha/2, mean = 0, sd = 1, lower.tail = FALSE)
IC <- c(x_med - Z_alpha10*sigma/sqrt(n),
x_med + Z_alpha10*sigma/sqrt(n))
IC
## [1] 448.55381 451.44619
