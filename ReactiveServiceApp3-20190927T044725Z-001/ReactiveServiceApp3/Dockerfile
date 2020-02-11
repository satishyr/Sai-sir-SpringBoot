FROM openjdk:8u151-jdk-slim-stretch
MAINTAINER SaiKrishna Hari <sainit08@gmail.com>
ADD target/ReactiveServiceApp3-0.0.1-SNAPSHOT.jar movieservice.jar
ENTRYPOINT ["java", "-Xmx144m","-jar", "/movieservice.jar"]