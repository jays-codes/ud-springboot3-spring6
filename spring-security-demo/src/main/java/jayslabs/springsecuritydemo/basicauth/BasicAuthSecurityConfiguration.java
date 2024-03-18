package jayslabs.springsecuritydemo.basicauth;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BasicAuthSecurityConfiguration {
	
	@Bean
	@Order(SecurityProperties.BASIC_AUTH_ORDER)
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		
        http.sessionManagement(session -> session.
                sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		//http.formLogin(withDefaults());
        http.csrf(csrf -> csrf.disable());
		
		http.httpBasic(withDefaults());

		
		return http.build();
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedMethods("*")
				.allowedOrigins("http://localhost:3000");
			}
		};
	}
}
