# SportsService API
<hr>

This API provides access to information about sports matches, including completed and live matches, and enables filtering by team name.

## Features

- Get a list of all completed matches
- Get a list of all live matches
- Get a list of all matches
- Get a list of all matches filtered by team name


## API Endpoints

### Get All Completed Matches 

- **Request Method:** GET 
- **Path:**  /api/${api.version}/match/completed
- **Description:** Returns a list of all matches with status completed.

### Get All Live Matches 

- **Request Method:** GET 
- **Path:**  /api/${api.version}/match/live
- **Description:** Returns a list of all matches with status live.

### Get All Matches 

- **Request Method:** GET 
- **Path:**  /api/${api.version}/match/all
- **Description:** Returns a list of all matches.

### Get All Matches By team name

- **Request Method:** GET 
- **Path:**  /api/${api.version}/match
- **PathParam:** name
- **Description:** Returns a list of all matches filtered by team name.


## Technologies

The following technologies are used in this project:
- #### Java 17
- #### Spring Boot
- #### Maven

## API Documentation

API documentation is available through Swagger UI. To access the API documentation, please navigate to {{host}}/swagger-ui.html after starting the application.

## How to run

### Project
- In the project view, right-click on the main package of your application and select "Open Module Settings".
- In the "Project Structure" window, select "Project" on the left sidebar.
- Under "Project SDK", select "Java 17" from the drop-down menu.
- Under "Project language level", select "17 - Records, patterns, and sealed types".
- Click "Apply" and then "OK" to close the window.
- Now, to run your application, right-click on the main class (annotated with @SpringBootApplication) and select "Run 'SportServiceApiApplication'". This will launch the application using the default configuration provided by Spring Boot.

### Unit Tests
- Open your IntelliJ IDEA project.
- Open the "Run" menu and select "Edit Configurations".
- Click the "+" icon in the top left corner of the "Run/Debug Configurations" dialog and select "Maven".
- In the "Name" field, give a name to your test run configuration.
- In the "Command line" field, enter "test".
- Click "OK" to save your configuration.
- Click "Run" or press Shift + F10

<hr>

### Conclusion Thoughts

The API is built using several components: 

- Configurations
- Controllers
- Enums
- Modules
- Scheduler
- Services

By organizing each component into separate modules, controllers, services, enums, and schedulers, our project is designed for scalability and code readability, enabling it to be easily extended in the future.


For further improvements and a must for the application would be to implement profiles (production, development, test).

The test assertions could also be covered more deeply as the application scales.

I am assuming that the complexity of the queries and connections between the Source APIs would in a realtime project
increase (for the provided Source APIs we could also have created a Sport and a Tournament class) for future references.

This was my first time using SpringBoot and writing UnitTests, and I'm eager to continue learning and improving my skills 
in software development. I'm excited to explore new technologies and techniques to build even better projects in the future.

<hr>

### TODOs 

- Implement Caching -> Possible Redis; adding the @Cacheable annotation on-top of the function; Can check all the keys 
that are currently stored in cache; 
- Creating a Docker image so the project runs the same on every machine inside a container; Creating the Dockerfile and building the docker image