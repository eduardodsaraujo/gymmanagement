package br.com.fiap.gymmanagement.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenApi() {
		
		OpenAPI openAPI = new OpenAPI()
				.components(new Components())
				.info(new Info()
						.title("API Gym Management - FIAP")
						.description("Spring Boot API for gym management.")
						.version("v1")
						.contact(new Contact()
								.name("FIAP - Pós Tech")
								.url("https://on.fiap.com.br/")));
		
		return openAPI;
	}
}
