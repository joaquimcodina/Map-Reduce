FROM openjdk:latest
COPY src /usr/src/map-reduce
WORKDIR /usr/src/map-reduce
CMD ["java", "Main"]
