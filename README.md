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



