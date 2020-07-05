#!/bin/bash
#echo "----- CONSTRUYENDO .JAR CON MAVEN -----"
#mvn install -DskipTests
echo "----- GENERANDO Y DESPLEGANDO CONTENEDORES DOCKER -----"

echo "----- DESPLEGANDO CONTENEDOR DOCKER:    config-server      -----"
docker-compose up --build config-server

until curl -f "http://localhost:8888"; do
  >&2 echo "config-server is sleeping"
  sleep 1
done

echo "----- DESPLEGANDO CONTENEDOR DOCKER:    eureka-server      -----"
docker-compose up --build eureka-server

until curl -f "http://localhost:8761"; do
  >&2 echo "eureka-server is sleeping"
  sleep 1
done

echo "----- DESPLEGANDO ESTOS DE CONTENEDORES DOCKER  -----"
docker-compose up --build eureka-zuul

#docker-compose up --build