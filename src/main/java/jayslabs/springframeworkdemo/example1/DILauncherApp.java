package jayslabs.springframeworkdemo.example1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class Business {
	@Autowired
	Dependency1 dependency1;
	@Autowired
	Dependency2 dependency2;
	
	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}

}

@Component

class Dependency1 {
}

@Component
class Dependency2 {
}

@Configuration
@ComponentScan("jayslabs.springframeworkdemo.example1")
public class DILauncherApp {

	public static void main(String[] args) {

		try (var ctx = new AnnotationConfigApplicationContext(DILauncherApp.class)) {

			Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(ctx.getBean(Business.class));
		}
	}

}
