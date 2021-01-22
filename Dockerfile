FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} store-management-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/store-management-1.0-SNAPSHOT.jar"]