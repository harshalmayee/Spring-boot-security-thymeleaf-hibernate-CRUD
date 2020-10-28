package com.javaguides;

import com.javaguides.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class RegistrationLoginSpringBootSecurityThymeleafHibernateApplication {

	private static final Logger log= LoggerFactory.getLogger(RegistrationLoginSpringBootSecurityThymeleafHibernateApplication.class);

	public static void main(String[] args) {
		log.info("Application Started....");
		SpringApplication.run(RegistrationLoginSpringBootSecurityThymeleafHibernateApplication.class, args);
	}

}
