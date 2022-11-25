FROM maven:3.8.6-amazoncorretto-19 AS build

COPY pom.xml ./pom.xml

RUN mvn -B -f ./pom.xml dependency:resolve dependency:resolve-plugins

COPY src ./src

RUN mvn -f ./pom.xml clean package

FROM amazoncorretto:19

COPY --from=build /target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]