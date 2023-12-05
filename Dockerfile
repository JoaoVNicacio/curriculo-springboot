FROM openjdk:17

COPY target/curriculo-0.0.1-SNAPSHOT.jar /app/curriculo-app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "curriculo-app.jar"]