FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/cities-0.0.1.jar
COPY ${JAR_FILE} app_cities.jar
ENTRYPOINT [ "java", "-jar", "app_cities.jar"]