FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/sb-hello-world.jar
COPY ${JAR_FILE} sb-hello-world.jar
ENTRYPOINT ["java","-jar","/sb-hello-world.jar"]