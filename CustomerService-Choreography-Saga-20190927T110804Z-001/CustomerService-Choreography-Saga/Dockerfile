FROM openjdk:8u151-jdk-slim-stretch
MAINTAINER SaiKrishna Hari <sainit08@gmail.com>
ADD target/CustomerService-Choreography-Saga-0.0.1-SNAPSHOT.jar customerservice.jar
ENTRYPOINT ["java", "-Xmx144m","-jar", "/customerservice.jar"]