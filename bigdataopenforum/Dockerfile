FROM maven:3.8.4-jdk-11-slim AS build
WORKDIR /bigdataopenforum
COPY . .
RUN mvn -f pom.xml clean install -DskipTests=true -Dspring.profiles.active=prod


FROM adoptopenjdk/openjdk11:latest
COPY --from=build /bigdataopenforum/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","app.jar"]
