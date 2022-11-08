FROM openjdk:11
ADD /target/command_sp_boot-0.0.1-SNAPSHOT.jar service.jar
ENTRYPOINT ["java", "-jar", "service.jar"]
