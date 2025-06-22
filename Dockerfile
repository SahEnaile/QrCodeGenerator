FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jat app.jar

ARG AWS_ACCESS_KEY_ID
ARG AWS_SECRET_KEY_ID

ENV AWS_REGION=us-east-2
ENV AWS_S3_BUCKET=qrcorde-generator

ENTRYPOINT ["java", "-jar", "app.jar"]