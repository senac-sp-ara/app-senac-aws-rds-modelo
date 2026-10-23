# Estágio 1: Build da aplicação (imagem com Maven, não depende do mvnw/.mvn)
FROM maven:3.9-eclipse-temurin-21-alpine AS builder
WORKDIR /app

# Copia o pom e baixa dependências (aproveita cache de camadas)
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copia o código fonte e compila o JAR (os testes rodam; se falharem, a imagem não é gerada)
COPY src ./src
RUN mvn clean package -B

# Estágio 2: Imagem final enxuta de execução
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Cria usuário não-root por segurança
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]
