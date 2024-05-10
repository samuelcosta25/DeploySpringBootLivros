# Estágio de compilação
FROM ubuntu:latest AS build

# Instale o OpenJDK 17
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
RUN apt-get install maven -y 

# Copie o código-fonte para o contêiner
COPY . .

# Compile o projeto com Maven
RUN mvn clean install

# Estágio de execução
FROM openjdk:17-jdk-slim

# Exponha a porta 8080
EXPOSE 8080

# Copie o arquivo JAR da etapa de compilação para o contêiner de execução
COPY --from=build /target/lojalivro-0.0.1-SNAPSHOT.jar app.jar

# Defina o comando de inicialização da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]