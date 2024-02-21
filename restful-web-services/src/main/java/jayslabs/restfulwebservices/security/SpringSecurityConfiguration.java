package jayslabs.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//all request to be authenticated
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		
		//show login page if req isnt authenticated
		http.httpBasic(Customizer.withDefaults());
		
		//CSRF -> POST, PUT
		http.csrf(csrf->csrf.disable());
		
		return http.build();
	}
}
