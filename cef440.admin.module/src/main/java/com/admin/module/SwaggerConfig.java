
package com.admin.module;

/*import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;



@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Spring Boot REST API", "Spring Boot REST API for Admin Module of CEF440", "1.0",
				"Terms of service",
				new Contact("DOMOU NAMOU Brice Armel", "https://github.com/DBryzz/restful-web-services.git",
						"domoubrice@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", null);
		return apiInfo;
	}
	
	
	/*
	 * @Bean public Docket apiS() { return new Docket(DocumentationType.SPRING_WEB)
	 * .select() .apis(RequestHandlerSelectors.any()) //.paths(regex("/product.*"))
	 * //.paths(Predicates.not(PathSelectors.regex("/error.*")))
	 * //.paths(Predicates.not(PathSelectors.regex("/actuator.*")))
	 * .paths(PathSelectors.any()) .build() .apiInfo(metaData()); }
	 * 
	 */

	 
}


/*
 * private ApiInfo metadata() { return new
 * ApiInfoBuilder().title(applicationName + " API").description(applicationName
 * + ": Api Service") .version("1.0").build().apiInfo(metaData()); }
 */


/*
 * public static final Contact DEFAULT_CONTACT = new Contact(
 * "DOMOU NAMOU Brice Armel",
 * "https://github.com/DBryzz/restful-web-services.git",
 * "domoubrice@gmail.com");
 * 
 * public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
 * "Bryzz API Title", "Bryzz API Description", "1.0", "urn:tos",
 * DEFAULT_CONTACT, "Apache 2.0", "http://www/apache.org/licenses/LICENSE-2.0");
 * 
 * private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new
 * HashSet<String>(Arrays.asList("application/json", "application/xml"));
 */

/*
 * @Bean public Docket api() { return new
 * Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(
 * DEFAULT_PRODUCES_AND_CONSUMES) .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
 * 
 * }
 */


/*
 * package net.gogroups.gosupportme.config;
 * 
 * import com.google.common.base.Predicates; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.Profile; import
 * springfox.documentation.builders.ApiInfoBuilder; import
 * springfox.documentation.builders.ParameterBuilder; import
 * springfox.documentation.builders.PathSelectors; import
 * springfox.documentation.builders.RequestHandlerSelectors; import
 * springfox.documentation.schema.ModelRef; import
 * springfox.documentation.service.ApiInfo; import
 * springfox.documentation.spi.DocumentationType; import
 * springfox.documentation.spring.web.plugins.Docket; import
 * springfox.documentation.swagger2.annotations.EnableSwagger2;
 * 
 * import java.util.Arrays; import java.util.HashSet;
 * 
 *//**
	 * User: Edward Tanko <br/>
	 * Date: 5/29/19 8:58 PM <br/>
	 *//*
		 * 
		 * 
		 * @Configuration
		 * 
		 * @EnableSwagger2
		 * 
		 * @Profile("!prod") public class SwaggerConfig {
		 * 
		 * @Value("${spring.application.name}") private String applicationName;
		 * 
		 * @Bean public Docket api() { HashSet<String> consumesAndProduces = new
		 * HashSet<>(Arrays.asList("application/json"));
		 * 
		 * return new Docket(DocumentationType.SWAGGER_2) .apiInfo(metadata())
		 * .consumes(consumesAndProduces) .produces(consumesAndProduces)
		 * .pathMapping("/") .globalOperationParameters( Arrays.asList(new
		 * ParameterBuilder() .name("Authorization") .defaultValue("Bearer ")
		 * .description("Security token") .modelRef(new ModelRef("string"))
		 * .parameterType("header") .required(true) .build())) .select()
		 * .apis(RequestHandlerSelectors.any())
		 * .paths(Predicates.not(PathSelectors.regex("/error.*")))
		 * .paths(Predicates.not(PathSelectors.regex("/actuator.*"))) .build(); }
		 * 
		 * private ApiInfo metadata() { return new ApiInfoBuilder()
		 * .title(applicationName+" API") .description(applicationName+ ": Api Service")
		 * .version("1.0") .build(); } }
		 */
