FROM openjdk:11
COPY target/uam-0.0.1-SNAPSHOT.jar uam-1.0.0.jar
ENTRYPOINT ["java","-jar","/uam-1.0.0.jar"]