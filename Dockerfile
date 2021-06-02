FROM openjdk:8
ADD target/spring-boot-security-thymeleaf-hibernate.jar spring-boot-security-thymeleaf-hibernate.jar
EXPOSE 8080
ENTRYPOINT ["java" ,"-jar" ,"spring-boot-security-thymeleaf-hibernate.jar"]