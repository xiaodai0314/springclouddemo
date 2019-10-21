FROM java:8
VOLUME /tmp
ADD provider-user-nologin-0.0.1.jar app.jar
EXPOSE 8087
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
