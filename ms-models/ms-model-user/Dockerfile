FROM openjdk:8
VOLUME /tmp
ADD ./target/ms-model-user-0.0.1-SNAPSHOT.jar ms-model-user.jar
ENTRYPOINT ["java","-jar","/ms-model-user.jar"]