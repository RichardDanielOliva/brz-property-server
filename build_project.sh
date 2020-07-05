#!/bin/bash
#echo "----- CONSTRUYENDO .JAR CON MAVEN -----"
#mvn install -DskipTests
echo "----- GENERANDO Y DESPLEGANDO CONTENEDORES DOCKER -----"

echo "----- DESPLEGANDO CONTENEDOR DOCKER:    config-server      -----"
docker-compose up --build config-server

echo "----- DESPLEGANDO CONTENEDOR DOCKER:    eureka-server      -----"
docker-compose up --build eureka-server

until curl -f http://localhost:8761; do
  >&2 echo "Postgres is unavailable - sleeping"
  sleep 1
done

#docker-compose up --build eureka-zuul

#docker-compose up --build