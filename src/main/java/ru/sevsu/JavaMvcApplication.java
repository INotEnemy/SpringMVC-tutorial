package ru.sevsu;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@Configuration
@EnableSwagger2
public class JavaMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaMvcApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Курс по Java MVC",
				"Разрабатывается для студентов СевГу",
				"0.1",
				"",
				new Contact("", "", "Vladiok2@mail.ru"),
				"",
				"",
				Collections.emptyList() //vendorExtensions
		);
	}

}
