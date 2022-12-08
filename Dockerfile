FROM openjdk:11
VOLUME /tmp
ADD ./target/client-service-1.0-SNAPSHOT.jar client.jar
ENTRYPOINT ["java","-jar","client.jar"]