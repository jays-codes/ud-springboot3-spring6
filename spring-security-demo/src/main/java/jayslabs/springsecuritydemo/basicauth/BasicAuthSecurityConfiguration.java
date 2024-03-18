package jayslabs.springsecuritydemo.basicauth;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
	
	@Bean
	public UserDetailsService userDetailsService() {
		
        var user1 = User
//        		.builder().passwordEncoder(passwordEncoder)
								//.username("jaymenorca")
                				.withUsername("jaymenorca")
                                .password("{noop}123456")
        //                        .authorities("read")
                                .roles("ADMIN")
                                .build();
        
        var user2 = User.withUsername("ethan")
                .password("{noop}hello123")
                //.authorities("read")
                .roles("USER")
                .build();
        
		return new InMemoryUserDetailsManager(user1, user2);
	}
}
