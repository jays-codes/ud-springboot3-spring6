package jayslabs.springframeworkdemo.section4;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{
}

@Component
@Lazy
class ClassB{
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		System.out.println("ClassB is being initialized...");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("inside classB.doSomething()...");
	}
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApp {

	public static void main(String[] args) {
		try(
				var ctx = new AnnotationConfigApplicationContext(LazyInitializationLauncherApp.class)
				){
			ctx.getBean(ClassB.class).doSomething();
			
			//Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

		}
	}

}
