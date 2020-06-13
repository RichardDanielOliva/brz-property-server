FROM openjdk:8
VOLUME /tmp
EXPOSE 58817
ADD ./target/ms-service-azure-storage-0.0.1-SNAPSHOT.jar ms-services-azure-storage.jar
ENTRYPOINT ["java","-jar","/ms-services-azure-storage.jar"]