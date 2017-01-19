# spring-boot-petstore
A dummy pet store to play with Spring Boot and Spring Cloud frameworks

Features:
* Jetty server instead of the default one used by spring boot (tomcat)
* Database Access using an in-memory embeded data base (H2DB via a JPA repository implementation)
* Data Caching using the default spring cache storage (ConcurrentHashMap)
* Distributed configuration using Spring Cloud Config Server and Client
  * Spring Cloud Config server source is a git repo (config files by profile in this-repo/config)

# Services

## Config Server

A distributed config server for the petstore inventory app

### run

```
cd config-server/
gradle build
java -jar build/libs/config-0.0.1-SNAPSHOT.jar
```

## Petstore Inventory

A dummy petstore that lets you add/update/delete pets to the inventory, find them by type, or list them all

### run

```
cd petstore-inventory/
gradle build
java -jar build/libs/inventory-0.0.1-SNAPSHOT.jar
```
