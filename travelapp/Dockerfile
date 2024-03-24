FROM openjdk

LABEL authors="Abhishek"

EXPOSE 8080

WORKDIR /travelapp

COPY . /travelapp

USER root

RUN chmod +x mvnw && \
    ./mvnw clean install && \
    chmod +x target/travelapp-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/travelapp/target/travelapp-0.0.1-SNAPSHOT.jar"]
