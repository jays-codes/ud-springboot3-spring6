package jayslabs.springframeworkdemo.hworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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

	@Bean
	@Qualifier("chosenaddress")
	public Address address3() {
		return new Address("Six Park", "Toronto");
	}
	
	@Bean(name="hideout")
	@Primary
	public Address address2() {
		return new Address("5 Park", "Toronto");
	}
	
	@Bean
	public Person manager() {
		return new Person("Big Boss", 55, new Address("Big Street", "Big City"));
	}
	
	@Bean
	public Person emergencycontact(String name, int age, @Qualifier("chosenaddress") Address address) {
		return new Person(name, age, address);
	}
	
	@Bean
	@Primary
	public Person person4(String name, int age, Address address) {
		return new Person(name, age, address);
	}
	
}
