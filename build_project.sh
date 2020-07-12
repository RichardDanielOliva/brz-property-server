#!/bin/bash
#echo "----- CONSTRUYENDO .JAR CON MAVEN -----"
mvn install -DskipTests
echo "----- GENERANDO Y DESPLEGANDO CONTENEDORES DOCKER -----"

echo "----- DESPLEGANDO CONTENEDOR DOCKER:    config-server      -----"
docker-compose up -d config-server

echo "----- DESPLEGANDO CONTENEDOR DOCKER:    eureka-server      -----"
docker-compose up -d eureka-server

until curl -f "http://localhost:8761"; do
  >&2 echo "eureka-server no se ha desplegado todavia"
  sleep 10
done

echo "----- DESPLEGANDO CONTENEDOR DEL API GATEWAY: eureka-zuul"
docker-compose up -d eureka-zuul

echo "----- DESPLEGANDO CONTENEDORES DOCKER ms 1er nivel models  -----"
docker-compose up -d ms-model-home ms-model-office ms-model-premise ms-model-user


echo "----- DESPLEGANDO CONTENEDORES  PARA SEGURIDAD: server-authentification"
docker-compose up -d server-authentification

echo "----- DESPLEGANDO CONTENEDORES  PARA SEGURIDAD: security-oauth"
docker-compose up -d security-oauth

echo "----- TODOS LOS CONTENEDORES HAN SIDO INICIADO      -----"
sleep 30