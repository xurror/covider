package ub.covid.fet.config;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .pathMapping("/")
            .globalOperationParameters(
                Arrays.asList(new ParameterBuilder()
                    .name("Authorization")
                    .defaultValue("Bearer ")
                    .description("Security token")
                    .modelRef(new ModelRef("string"))
                    .parameterType("header")
                    .required(true)
                    .build()))
            .select()
                .apis(RequestHandlerSelectors.basePackage("ub.covid.fet.controller"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfoBuilder()
                .description("Backend API For Covider  ")
                .title("A Covid Management Api ")
                .version("v1.0.0 [COVIDER]")
                .build();
    }

}
