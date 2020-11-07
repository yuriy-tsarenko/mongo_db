FROM openjdk:11

COPY ./target/mongo_db.jar /application.jar

ENTRYPOINT ["java","-jar","/application.jar"]

EXPOSE 8080
