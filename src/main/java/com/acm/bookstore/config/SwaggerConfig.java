package com.acm.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String CONTACT_EMAIL = "cesargt92@gmail.com";
	private static final String REPOSITORY = "https://github.com/Augusto-Cesar/";
	private static final String CONTACT_NAME = "Augusto Cesar";
	private static final String API_VERSION = "1.0.0";
	private static final String API_DESCRIPTION = "Bookstore api for study SPring Boot and Rest";
	private static final String API_TITLE = "Bookstore ACM";
	private static final String BASE_PACKAGE = "com.acm.bookstore";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build().apiInfo(buildApiInfo());
	}

	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder()
				.title(API_TITLE)
				.description(API_DESCRIPTION)
				.version(API_VERSION)
				.contact(new Contact(CONTACT_NAME, REPOSITORY, CONTACT_EMAIL))
				.build(); 
	}
}
