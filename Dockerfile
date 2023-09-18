FROM openjdk:17

WORKDIR /app

COPY target/Simulation-1.0-SNAPSHOT.jar simulation.jar

ENTRYPOINT ["java","-jar","simulation.jar"]