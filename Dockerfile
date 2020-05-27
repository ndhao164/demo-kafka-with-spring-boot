FROM openjdk:8u141-jre
VOLUME /tmp
ADD target/demo-kafka-with-spring-boot-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT exec java -jar app.jar