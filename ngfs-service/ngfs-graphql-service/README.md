# Ngfs GraphQL Spring Boot Service

Sample GraphQL Service using SpringBoot and graphql-java

Prerequisites:
- You have installed:
   - Java SE SDK > 1.7
   - Apache Maven > 3.5
   - Eclipse IDE or equivalent with the SpringBoot Tools Suite (optional)
- DEV_HOME environmental variable is set (eg: ~/Development or C:\\Development)  
- PATH variable has been set to include Java and Maven bin folders
## Build (from ngfs-service folder)

`mvn clean install -DskipTests`

## Start server

Run (from ngfs-graphql-service folder):

`cd $DEV_HOME/ngfs/ngfs-service/ngfs-graphql-service`
`mvn spring-boot:run`

## Open graphql UI

[GraphQL UI](http://localhost:8520/graphiql)

## Add people

-  Copy and paste the query from [person.gql](./src/main/resources/queries/person.gql) into the GraphQL query window
-  Copy and paste the json from [personInput.json](./src/main/resources/queries/personInput.json) into the GraphQL variable window

-  Edit the personInput json varaible
-  Run the mutation  
-  Run the query to get the list of peoaple
-  Repeat to add other people
