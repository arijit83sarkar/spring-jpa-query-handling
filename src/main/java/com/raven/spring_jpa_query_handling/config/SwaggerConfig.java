package com.raven.spring_jpa_query_handling.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private static final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);

    @Bean
    public OpenAPI openAPI() {
        log.info("Initializing Swagger OpenAPI configuration...");
        return new OpenAPI()
                .info(new Info()
                        .title("Spring JPA Query Handling API")
                        .description("REST API documentation for Spring JPA Query Handling application")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Raven")
                                .email("mail2arijit83@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}