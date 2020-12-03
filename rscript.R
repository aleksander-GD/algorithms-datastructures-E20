# Problem 1
home = setwd(Sys.getenv("HOME"));
fpath = file.path(home);
setwd(fpath)

dataNLogNAverage <- read.csv(file = 'test.csv')

head(dataNLogNAverage)
names(dataNLogNAverage)[names(dataNLogNAverage) == "X10000"] <- "N"
names(dataNLogNAverage)[names(dataNLogNAverage) == "X1820000"] <- "counts"
head(dataNLogNAverage)


plot(x=dataNLogNAverage$N, y=dataNLogNAverage$counts, type = "l", xlab = "N size", ylab = "count average", col="blue")
reg <- lm(counts~N, data = dataNLogNAverage)
legend("topleft",c("counter"),fill=c("blue"))

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

par(mfrow = c(1, 2))
plot(x=dataNLogNAverage$N, y=dataNLogNAverage$counts, type = "l", xlab = "N size", ylab = "count average", col="blue")
reg <- lm(counts~N, data = dataNLogNAverage)
legend("topleft",c("counter"),fill=c("blue"))
#abline(reg, col="orange")
summary(reg)
#legend("topleft",c("regression","counter"),fill=c("orange","blue"))


# Estimate = lm(dataNLogNAverage$counts ~ dataNLogNAverage$N)
# logEstimate = lm(dataNLogN$NlogN ~ dataNLogN$N)

# plot(dataNLogNAverage$N,predict(Estimate),type='l',col='blue')
#lines(dataNLogN$N,predict(logEstimate),col='red')
# points(dataNLogNAverage$N,dataNLogNAverage$counts)

# summary(Estimate)

plot(x=dataNLogN$N, y=dataNLogN$NlogN, type = "l", xlab = "N size", ylab = "O(N*LogN)", col="red")
legend("topleft",c("O(N*logN)"),fill=c("red"))


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

par(mfrow = c(1, 2))
plot(x=dataNAverage$N, y=dataNAverage$counts, type = "l", xlab = "N size", ylab = "count average", col="blue")
reg<-lm(counts ~ N, data = dataNAverage)
#coeff=coefficients(reg)
#eq = paste0("y = ", round(coeff[2],1), "*x ", round(coeff[1],1))
abline(reg, col="orange")
legend("topleft",c("counter", "regression"),fill=c("blue","orange"))
resid(reg)
plot(resid(reg))
summary(reg)

plot(x=dataN$N, y=dataN$cN, type = "l", xlab = "N size", ylab = "O(N)", col="red")
legend("topleft",c("O(N)"),fill=c("red"))
