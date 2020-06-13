FROM openjdk:8
VOLUME /tmp
ADD ./target/ms-model-premise-0.0.1-SNAPSHOT.jar ms-model-premise.jar
ENTRYPOINT ["java","-jar","/ms-model-premise.jar"]