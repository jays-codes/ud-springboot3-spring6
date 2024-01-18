package jayslabs.springframeworkdemo.example2;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApp {

	public static void main(String[] args) {

		try (var ctx = new AnnotationConfigApplicationContext(
				SimpleSpringContextLauncherApp.class)) {
			
			Arrays.stream(
					ctx.getBeanDefinitionNames())
			.forEach(System.out::println);
		}
	}

}
