install.packages("ggplot")
install.packages("ggplot2")
library(ggplot2)
library(ggplot)
# Problem 1
home = setwd(Sys.getenv("HOME"));
fpath = file.path(home);
setwd(fpath)

dataNLogNAverage <- read.csv(file = 'dataNLogNAverage.csv')

head(dataNLogNAverage)
names(dataNLogNAverage)[names(dataNLogNAverage) == "X0"] <- "N"
names(dataNLogNAverage)[names(dataNLogNAverage) == "X0.1"] <- "counts"
head(dataNLogNAverage)

dataNLogN <- read.csv(file = 'dataNLogN.csv')

head(dataNLogN)
names(dataNLogN)[names(dataNLogN) == "X0"] <- "N"
names(dataNLogN)[names(dataNLogN) == "X0.0"] <- "NlogN"
head(dataNLogN)

plot(x=dataNLogNAverage$N, y=dataNLogNAverage$counts, type = "l", xlab = "count", ylab = "N size", col="blue")
legend("topleft",c("counter"),fill=c("blue"))
plot(x=dataNLogN$N, y=dataNLogN$NlogN, type = "l", xlab = "O(N*LogN)", ylab = "N size", col="red")
#lines(x=dataNLogN$N, y=dataNLogN$NlogN, type = "l", col="red")

reg <- lm(counts~N, data = dataNLogNAverage)
abline(reg, col="orange")
legend("topleft",c("regression","O(N*logN)"),fill=c("orange","red"))
summary(reg)

# Problem 2

dataNAverage <- read.csv(file = 'dataNAverage.csv')

head(dataNAverage)
names(dataNAverage)[names(dataNAverage) == "X0"] <- "N"
names(dataNAverage)[names(dataNAverage) == "X0.1"] <- "counts"
head(dataNAverage)

dataN <- read.csv(file = 'dataN.csv')

head(dataN)
names(dataN)[names(dataN) == "X0"] <- "N"
names(dataN)[names(dataN) == "X0.1"] <- "cN"
head(dataN)

plot(x=dataNAverage$N, y=dataNAverage$counts, type = "l", xlab = "count", ylab = "N size", col="blue")
plot(x=dataN$N, y=dataN$cN, , type = "l", xlab = "O(N)", ylab = "N size", col="red")

reg<-lm(counts ~ N, data = dataNAverage)
coeff=coefficients(reg)
eq = paste0("y = ", round(coeff[2],1), "*x ", round(coeff[1],1))
abline(reg, col="orange")
legend("topleft",c("counter","O(N)", "linear regression on counter"),fill=c("blue","red", "orange"))
resid(reg)
plot(resid(reg))
summary(reg)
#fit <- lm(dataNAverage$N~dataNAverage$counts, data=dataNAverage)
#lines(dataNAverage$N, fitted(fit), col="orange")