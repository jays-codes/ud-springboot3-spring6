package jayslabs.todolistwebappdemo.todo.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

//	@Bean
//	public InMemoryUserDetailsManager createUserDetailsManager() {
//
//		UserDetails userDetails1 = createNewUser("jaymenorca", "123456");
//		UserDetails userDetails2 = createNewUser("ethan", "hello123");
//
////		UserDetails userDetails = User.withDefaultPasswordEncoder().username("jaymenorca")
////		.password("123456")
////		.roles("USER","ADMIN")
////		.build();
//
//		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
//	}
//
//	private UserDetails createNewUser(String username, String password) {
//		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
//
//		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password)
//				.roles("USER", "ADMIN").build();
//		return userDetails;
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpsec) throws Exception {
		httpsec.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		
		//httpsec.formLogin(Customizer.withDefaults());
		
		httpsec.httpBasic(Customizer.withDefaults());
		
		httpsec.sessionManagement(session -> session.sessionCreationPolicy(
				SessionCreationPolicy.STATELESS));
		
		httpsec.csrf(csrf->csrf.disable());
		
		//httpsec.headers(header->header.frameOptions(frameOptions->frameOptions.disable()));
		
		return httpsec.build();
	}
}
