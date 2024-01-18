package jayslabs.springframeworkdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {};
record Address(String firstLine, String city) {};

@Configuration
public class HWorldConfiguration {

	@Bean
	public String name() {
		return "Jay";
	}
	
	@Bean
	public int age() {
		return 25;
	}
	
	@Bean
	public Person person() {
		return new Person("Jay", 35);
	}
	
	@Bean
	public Address address() {
		return new Address("4 Park", "Toronto");
	}
}
