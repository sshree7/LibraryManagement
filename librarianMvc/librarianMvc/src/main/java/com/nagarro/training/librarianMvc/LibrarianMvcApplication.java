package com.nagarro.training.librarianMvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.nagarro.training.librarianMvc")
public class LibrarianMvcApplication {

	private static final Logger log = LoggerFactory.getLogger(LibrarianMvcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LibrarianMvcApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


}
