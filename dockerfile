FROM java:8
EXPOSE 9999
ADD FoodOrder/target/FoodOrder.war FoodOrder.war
ENTRYPOINT ["java", "-war", "FoodOrder-0.0.1-SNAPSHOT.war"]
