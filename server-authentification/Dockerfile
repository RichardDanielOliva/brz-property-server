FROM openjdk:8
VOLUME /tmp
EXPOSE 8100
ADD ./target/serverAuthentification-0.0.1-SNAPSHOT.jar server-authentification.jar
ENTRYPOINT ["java","-jar","/server-authentification.jar"]