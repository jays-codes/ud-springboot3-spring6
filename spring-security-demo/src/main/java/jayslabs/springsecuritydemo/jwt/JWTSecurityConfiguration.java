package jayslabs.springsecuritydemo.jwt;

import static org.springframework.security.config.Customizer.withDefaults;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;


//@Configuration
public class JWTSecurityConfiguration {
	
	@Bean
	@Order(SecurityProperties.BASIC_AUTH_ORDER)
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		
        http.sessionManagement(session -> session.
                sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.csrf(csrf -> csrf.disable());
		
		http.httpBasic(withDefaults());

        http.headers(header->header
        		.frameOptions(frameOptions->frameOptions.sameOrigin()));

        http.oauth2ResourceServer((oauth2) -> oauth2.jwt(withDefaults()));
        
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
	public DataSource datasource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		
        var user1 = User
                .withUsername("jaymenorca")
                .password("123456")
                .passwordEncoder( pwd -> passwordEncoder().encode(pwd))
                .roles("ADMIN")
                .build();
        
        var user2 = User.withUsername("ethan")
        		.password("hello123")
        		.passwordEncoder(pwd->passwordEncoder().encode(pwd))
                .roles("USER")
                .build();
        
        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user1);
        jdbcUserDetailsManager.createUser(user2);
        
        return jdbcUserDetailsManager;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public KeyPair keyPair(){
		try {
			var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			return keyPairGenerator.generateKeyPair();
		} catch (Exception e) {
			throw new IllegalStateException(
					"Unable to generate an RSA Key Pair",e);
		}
	}
	
	@Bean
	public RSAKey rsaKey() {
		KeyPair keyPair = keyPair();
		
		return new RSAKey
				.Builder((RSAPublicKey) keyPair.getPublic())
				.privateKey((RSAPrivateKey) keyPair.getPrivate())
				.keyID(UUID.randomUUID().toString())
				.build();
	}
	
	@Bean
	public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
		JWKSet jwkset = new JWKSet(rsaKey());
		return (((jwkSelector, securityContext) 
				-> jwkSelector.select(jwkset)));
	}
	
	@Bean
	JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource){
		return new NimbusJwtEncoder(jwkSource);
	}
	
	@Bean	
	JwtDecoder jwtDecoder() throws JOSEException {
		return NimbusJwtDecoder.withPublicKey(rsaKey().toRSAPublicKey())
				.build();
	}
}
