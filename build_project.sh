#!/bin/bash
#echo "----- CONSTRUYENDO .JAR CON MAVEN -----"
#mvn install -DskipTests
echo "----- GENERANDO Y DESPLEGANDO CONTENEDORES DOCKER -----"

echo "----- DESPLEGANDO CONTENEDOR DOCKER:    config-server      -----"
docker-compose up --build config-server

echo "----- DESPLEGANDO CONTENEDOR DOCKER:    eureka-server      -----"
docker-compose up --build eureka-server

#docker-compose up --build eureka-zuul

#docker-compose up --build