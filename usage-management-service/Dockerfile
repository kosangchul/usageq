FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY build/libs/usage-management-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
