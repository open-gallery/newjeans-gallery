FROM openjdk:11-jre
COPY ./build/libs/newjeans-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]