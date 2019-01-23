# Ngfs GraphQL Spring Boot Service

Sample GraphQL Service using SpringBoot and graphql-java

## Build (from ngfs-service folder)

`mvn clean install -DskipTests`

## Start server

Run (from ngfs-graphql-service folder):

`mvn spring-boot:run`

## Open graphql UI

[GraphQL UI](http://localhost:8520)

## Add people

### Copy and paste the query from [person.gql](./src/main/resources/queries/person.gql) into the GraphQL query window
### Copy and paste the json from [personInput.json](./src/main/resources/queries/personInput.json) into the GraphQL variable window 

### Edit the personInput json varaible
### Run the mutation  
### Run the query to get the list of peoaple
### Repeat to add other people
