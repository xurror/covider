package cm.ubuea.covider;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
// import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
// import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServerApplication {

	private static class Configuration extends ServletInitializer{ }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(Configuration.class);
    }

    public static void main(String[] args) {
        // ConfigurableApplicationContext ctx = configureApplication(new SpringApplicationBuilder(CoviderApplication.class)).run(args);
        configureApplication(new SpringApplicationBuilder(ServerApplication.class)).run(args);
	}

}
