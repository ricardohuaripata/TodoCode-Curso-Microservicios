FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/carts-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_carts.jar
ENTRYPOINT [ "java", "-jar", "app_carts.jar"]