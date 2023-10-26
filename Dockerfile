FROM openjdk:11-jre-slim
COPY build/libs/fitness.jar /fitness.jar
CMD ["java", "-jar", "/fitness.jar"]