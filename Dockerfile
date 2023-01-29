# base docker image
FROM openjdk:11
LABEL maintainer="thansen"
ADD target/bookreview-0.0.1-SNAPSHOT.jar springboot-docker-bookreview.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-bookreview.jar"]