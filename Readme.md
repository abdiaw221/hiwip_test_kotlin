# Organization

This project contains all that's needed to build, run and deploy the backend.

```
/dep            usefull dependencies for running the service locally
/gradle         gradle dependencies
/src            project sources
```

# Setup

## Building and running locally

To build and run the project, you need the following environment:

- JDK 11 or higher
- docker
- docker-compose

# Running

To run locally:

1) Clean build project as following:

```
./gradlew clean build
```

2) you need create the build with docker compose to build docker image using built jar file, run as following:
   
Before running the command, make sure this property is `spring.data.mongodb.host=mongodb`

```
docker-compose -f dep/docker-compose.yml build
```

3) you need to launch the external services (API service , Mongo DB etc...) as following:

```
docker-compose -f dep/docker-compose.yml up -d
```

## Integration tests
