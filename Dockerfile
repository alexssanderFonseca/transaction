FROM openjdk:11
MAINTAINER ALEX
WORKDIR app
COPY ./build/libs/transacao-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","transacao-0.0.1-SNAPSHOT.jar"]
