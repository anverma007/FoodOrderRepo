FROM openjdk:8

RUN mkdir -p /usr/src/myapp

COPY target/FoodOrder-0.0.1-SNAPSHOT.war /usr/src/myapp

WORKDIR /usr/src/myapp

CMD ["java", "-jar", "FoodOrder-0.0.1-SNAPSHOT.war"]
