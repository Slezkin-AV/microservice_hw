FROM alpine/java:21-jdk
COPY ./target/srv3-1.0-SNAPSHOT.jar /usr/local/bin/srv3-1.0-SNAPSHOT.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/usr/local/bin/srv3-1.0-SNAPSHOT.jar"]