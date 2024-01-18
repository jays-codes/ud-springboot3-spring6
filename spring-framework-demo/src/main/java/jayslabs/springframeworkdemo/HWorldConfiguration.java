package jayslabs.springframeworkdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HWorldConfiguration {

	@Bean
	public String name() {
		return "Jay";
	}
}
