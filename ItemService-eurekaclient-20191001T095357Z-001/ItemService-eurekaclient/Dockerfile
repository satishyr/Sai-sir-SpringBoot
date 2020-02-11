FROM openjdk:8u151-jdk-slim-stretch
MAINTAINER SaiKrishna Hari <sainit08@gmail.com>
ADD target/ItemService-0.0.1-SNAPSHOT.jar itemservice.jar
ENTRYPOINT ["java", "-Xmx144m","-jar", "/itemservice.jar"]
EXPOSE 8787