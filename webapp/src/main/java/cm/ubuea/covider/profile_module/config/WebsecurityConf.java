package cm.ubuea.covider.profile_module.config;

import cm.ubuea.covider.profile_module.services.UserProfileService;
import cm.ubuea.covider.profile_module.util.OneTimeAuthPerReqFilter;
import cm.ubuea.covider.profile_module.util.PwEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebsecurityConf extends WebSecurityConfigurerAdapter {
    private AuthResponseEntryPoint unauthorisedEntryPoint;
    private UserProfileService userProfileService;
    private OneTimeAuthPerReqFilter oncePerReqFilter;
    private PwEncoder pwEncoder;

    @Value("{domain.endpoints.get.userdetails}")
    private String authPath;

    public WebsecurityConf(AuthResponseEntryPoint unauthorisedEntryPoint,
                           UserProfileService userProfileService, OneTimeAuthPerReqFilter oncePerReqFilter,
                           PwEncoder pwEncoder) {
        this.unauthorisedEntryPoint = unauthorisedEntryPoint;
        this.userProfileService = userProfileService;
        this.oncePerReqFilter = oncePerReqFilter;
        this.pwEncoder = pwEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.addFilter(cors());

        http.exceptionHandling()
                .authenticationEntryPoint(unauthorisedEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/protected/**")
                .hasAnyRole("USER", "AGENT")
                .and()
                .authorizeRequests()
                .antMatchers("/api/administrative/**")
                .hasAnyRole("AGENT")
                .anyRequest().permitAll();


        http.addFilterBefore(oncePerReqFilter, UsernamePasswordAuthenticationFilter.class);

        http.headers().frameOptions().sameOrigin().cacheControl(); //to disable caching
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userProfileService)
        .passwordEncoder(pwEncoder.passwordEncoder());
    }
    @Bean
    public AuthenticationManager authManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //VERY VERY INSECURED METHOD
    @Bean
    public CorsFilter cors() {
        UrlBasedCorsConfigurationSource s = new UrlBasedCorsConfigurationSource();

        CorsConfiguration conf = new CorsConfiguration();
        conf.setAllowCredentials(true);
        conf.addAllowedOrigin("*");
        conf.addAllowedMethod("POST");
        conf.addAllowedMethod("PUT");
        conf.addAllowedMethod("GET");

        s.registerCorsConfiguration("/**", conf);
        return new CorsFilter(s);
    }
}
