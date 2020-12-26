FROM openjdk:15-jdk-alpine

WORKDIR /app
COPY . .

RUN ./mvnw package -DskipTests
FROM openjdk:15-jdk-alpine

WORKDIR /app
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

COPY --from=0 /app/target/vtys-demo-0.0.2-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","./vtys-demo-0.0.2-SNAPSHOT.jar"]