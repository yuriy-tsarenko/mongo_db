# mongo_db
***
#### Objective
***
Validation of good practices, design patterns and knowledge of Spring Boot.
***
#### Statement
***
Develop a microservice in Spring Boot with WebFlux, functional endpoints and their unit tests, following
the conventions of a REST service.
It will have two endpoints, one to save objects and another to list all objects. The service should use
DTOs for communication with the outside world.
The microservice will save the data in MongoDB, using Docker. We will have two objects, the first will
have id and name (nodeRoot) and the second will have these same attributes and, in addition, a
description (nodeDesc). We want both objects to be stored in the same collection called “node”.
***
To build a .jar file of this project, follow these instructions:
***
* clone this project from this repository;
* install it via Maven (Maven is a Java tool, so you must have Java installed in order to proceed.);
* install Maven (use this link: https://maven.apache.org);
* enter command into terminal "mvn install";
* the file will be created in the directory "target";
to simplify this way (2-3 points of this instruction), just use UI of your IDE and Maven plugin;
***
check it out :)
Open to cooperation, glad for additions.
