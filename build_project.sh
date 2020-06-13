#!/bin/bash
echo "----- CONSTRUYENDO .JAR CON MAVEN -----"
mvn install -DskipTests
echo "----- GENERANDO Y DESPLEGANDO CONTENEDORES DOCKER -----"
docker-compose up --build