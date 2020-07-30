FROM openjdk:11-jdk
MAINTAINER experto.com
VOLUME /tmp
EXPOSE 7799
ADD target/a2-1.0.0.jar a2-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/a2-1.0.0.jar"]