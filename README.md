# brz-property-server
The objective of the practice is to implement a microservices architecture. For this purpose, a server was developed for a real estate search portal with Spring Framework 5 and its Spring Cloud Netflix - Eureka module 

# Components that support a microservices architecture
Although there is no concrete definition for implementing a microservices architecture, there are certain components that allow limiting the architecture's problems and taking advantage of its capabilities. To this end, the following components were implemented as part of the Spring Cloud Netflix Eureka module:
- Service registration/discovery: Spring Server Eureka. allows us to have a centralized and automated service registration. It provides the endpoints of the services for consumption
- Fault tolerance: Netflix Hystrix. Allows to define an alternate route in case of failure of some service.
- Load Balancing and Dynamic Rerouting: Netflix Ribbon. Allows to distribute between different instances the requests made. 
- Central configuration server: Spring Cloud Config Server. Centralizes and provides the configuration of each microservice.
- Gateway API: Netflix Zuul. For routing and application of filters.
- Spring Security Oauth2. A microservice is implemented to store users and roles, an authorization server based on JWT tokens, and access to resources is controlled from the Netflix Zuul Gateway API.
# Common microservice support and configuration.
Taking advantage of the capabilities offered by Spring Boot as a tool for dependency and configuration management, it was decided to extend its qualities and generate a separate Spring Boot Starter for the project. Among the tasks and functions implemented we have:

- Dependency control.
- Common libraries.
- Exception control. A controller that centrally manages the application's exceptions is enabled. 
- Auto-documentation. With Swagger 2

To use this functionality it is necessary to first compile the module and reference in the pom.xml file the services that intend to use it. In addition, for the centralized handling of exceptions and self-documentation, it must be enabled in the project properties. 
# Microservices

In essence, the microservices try to break down the system into independent work units, with very specific tasks. To this end, the following two levels (types) of microservices were established according to their function to be developed.
## 1st level microservices: access to database.
Within this category we find those microservices that have a database available and whose sole responsibility will be to serve as a bridge to the database. 

For an agile development we used Spring Data REST and Spring Data modules. These allow to abstract the specific details of the database access and even manage it in a declarative way in our CAD/Repositories.

For the advanced search of properties, a driver is enabled that will receive the search conditions, perform the respective checks to add "queries" to the MongoTemplate object and perform the search.

MongoDB was used as a non-relational database system. To do this, we used the Mongo Atlas service which allows us to have our database in the cloud.

The implemented microservices are in the ms-model directory. For a matter of time, it was only possible to develop the three services: ms-model-home, ms-model-office, ms-model-premise
## 2nd level microservices: business logic

Within this category are those microservices that aim at data validation and business logic. Unfortunately, due to time constraints, it was not possible to adequately implement all the microservices contemplated, so only the ms-services-property service is available. This contains an approximation of what we want to achieve with these microservices.

Both the RestTemplate API and Feign Netflix are used to consume the data of the 1st level microservices. In both cases, Ribbon is configured for load balancing.
