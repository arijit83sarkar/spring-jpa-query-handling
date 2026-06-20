package com.raven.spring_jpa_query_handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaQueryHandlingApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringJpaQueryHandlingApplication.class);

	public static void main(String[] args) {
		log.info("Starting Spring JPA Query Handling Application...");
		SpringApplication.run(SpringJpaQueryHandlingApplication.class, args);
		log.info("Application started successfully on port 8010");
		log.info("Swagger UI available at: http://localhost:8010/swagger-ui.html");
		log.info("API base URL: http://localhost:8010/api/v1");
		log.info("Actuator available at: http://localhost:8010/actuator");
	}

}
