FROM openjdk:latest

ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
# ecs-alb-507832375.ap-northeast-2.elb.amazonaws.com:8080/api