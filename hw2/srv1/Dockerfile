FROM alpine/java:21-jdk
COPY ./target/srv1-0.0.1-SNAPSHOT.jar /usr/local/bin/srv1-0.0.1-SNAPSHOT.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/usr/local/bin/srv1-0.0.1-SNAPSHOT.jar"]