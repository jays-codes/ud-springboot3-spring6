package jayslabs.springframeworkdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address) {};
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
		return new Person(name(), age(), address());
	}
	
	@Bean(name="crib")
	public Address address() {
		return new Address("4 Park", "Toronto");
	}
	
	@Bean(name="hideout")
	public Address address2() {
		return new Address("5 Park", "Toronto");
	}
	
	@Bean
	public Person manager() {
		return new Person("Big Boss", 55, new Address("Big Street", "Big City"));
	}
	
	@Bean
	public Person emergencycontact(String name, int age, Address crib) {
		return new Person(name, age, crib);
	}
}
