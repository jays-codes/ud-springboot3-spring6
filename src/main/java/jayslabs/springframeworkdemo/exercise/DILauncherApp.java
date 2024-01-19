package jayslabs.springframeworkdemo.exercise;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("jayslabs.springframeworkdemo.exercise")
public class DILauncherApp {

	public static void main(String[] args) {

		try (var ctx = new AnnotationConfigApplicationContext(DILauncherApp.class)) {

			//Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println("max: " + 
			ctx.getBean(BusinessCalculationService.class).findMax());
		}
	}

}
