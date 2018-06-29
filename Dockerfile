FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY /target/docker-spring-database-0.0.1-SNAPSHOT.jar satdb.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/satdb.jar"]