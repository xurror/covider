package cm.ubuea.covider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CoviderApplication {

  private static class Configuration extends ServletInitializer { }

  private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
    return builder.sources(Configuration.class);
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = configureApplication(new SpringApplicationBuilder(CoviderApplication.class)).run(args);
  }

  @Bean
  public Docket lDoc() {
    ParameterBuilder paramBuilder = new ParameterBuilder();
    paramBuilder.name("Authorization")
      .modelRef(new ModelRef("string"))
      .parameterType("header")
      .defaultValue("Bearer ")
      .required(true)
      .build();
    List<Parameter> params = new ArrayList<>();
    params.add(paramBuilder.build());

    return new Docket(DocumentationType.SWAGGER_2).select()
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.ant("/api/**"))
      .build().
        pathMapping("")
      .globalOperationParameters(params);
  }

}
