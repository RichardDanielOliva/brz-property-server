FROM openjdk:8
VOLUME /tmp
EXPOSE 58817
ADD ./target/ms-model-home-0.0.1-SNAPSHOT.jar ms-model-home.jar
ENTRYPOINT ["java","-jar","/ms-model-home.jar"]