FROM openjdk:8
VOLUME /tmp
ADD ./target/ms-model-office-0.0.1-SNAPSHOT.jar ms-model-office.jar
ENTRYPOINT ["java","-jar","/ms-model-office.jar"]