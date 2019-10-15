FROM java:8
EXPOSE 9999
ADD /target/FoodOrder-0.0.1-SNAPSHOT.war FoodOrder-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-war", "FoodOrder-0.0.1-SNAPSHOT.war"]
