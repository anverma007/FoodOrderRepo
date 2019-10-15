FROM tomcat:8.0
LABEL maintainer="alok.verma@mindtree.com"
ADD FoodOrder-web/target/FoodOrder-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh","run"]