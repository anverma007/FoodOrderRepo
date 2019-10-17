FROM java:8
EXPOSE 9999
ENTRYPOINT ["java", "-war", "FoodOrder-0.0.1-SNAPSHOT.war"]
