FROM openjdk:11
COPY ./src /usr/src/textcounter
WORKDIR /usr/src/textcounter
RUN javac App.java
ENTRYPOINT ["sh"]
