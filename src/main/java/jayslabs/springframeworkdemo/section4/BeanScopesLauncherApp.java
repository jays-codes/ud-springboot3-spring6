package jayslabs.springframeworkdemo.section4;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class Normal{
	
}

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class Prototype{
	
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApp {

	public static void main(String[] args) {

		try(
				var ctx = new AnnotationConfigApplicationContext(BeanScopesLauncherApp.class)
				){
			//Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(ctx.getBean(Normal.class));
			System.out.println(ctx.getBean(Normal.class));
			System.out.println(ctx.getBean(Normal.class));
			
			System.out.println(ctx.getBean(Prototype.class));
			System.out.println(ctx.getBean(Prototype.class));
			System.out.println(ctx.getBean(Prototype.class));
			
			
		}
		
	}

}
