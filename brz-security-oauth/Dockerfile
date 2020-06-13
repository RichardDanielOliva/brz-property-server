FROM openjdk:8
VOLUME /tmp
EXPOSE 9100
ADD ./target/brz-security-oauth-0.0.1-SNAPSHOT.jar security-oauth.jar
ENTRYPOINT ["java", "-jar", "/security-oauth.jar"]