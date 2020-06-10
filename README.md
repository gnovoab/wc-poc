# Overview

Proof of Concept for World cup microservices 


### Running the application
* Run `gradle build`
* Run `gradle bootRun`


### Endpoints

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html  ) 
 

### Database
This project is a Docker Compose file that contains PostgreSQL DB  ready to be integrate with any develoment locally

#### Run PostgreSQL DB's
docker-compose -f ./docker/db.yml up

####Create PostgreSQL DB's
DB details as follows: Host: localhost Port: 5432 DB: postgres Username: postgres * Password: postgres

To create a DB instance type the command below:

CREATE DATABASE **wc** OWNER postgres;