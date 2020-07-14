package com.admin.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
@EnableSwagger2WebMvc
@SpringBootApplication
public class Cef440AdminModuleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cef440AdminModuleApiApplication.class, args);
	}

	
}
