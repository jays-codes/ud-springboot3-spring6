package jayslabs.springframeworkdemo.section4_1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class ClassC{
	private ClassD classD;
	
	public ClassC(ClassD classD) {
		super();
		this.classD = classD;
		System.out.println("ClassC instance created...");
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("ClassC PostConstruct invoked......");
		//classD.getReady();
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("classC cleanUp() invoked...");
	}
}

@Component
class ClassD{
	public ClassD() {
		System.out.println("ClassD instance created...");
	}
	
	public void getReady() {
		System.out.println("Inside class D instance...");		
	}

	@PostConstruct
	public void initialize() {
		System.out.println("ClassD PostConstruct invoked......");
		//classD.getReady();
	}

	
	@PreDestroy
	public void cleanUp() {
		System.out.println("classD cleanUp() invoked...");
	}
}

@Configuration
@ComponentScan("jayslabs.springframeworkdemo.section4_1")
public class PostConstructPreDestroyLauncherApp {

	public static void main(String[] args) {

		try(
				var ctx = new AnnotationConfigApplicationContext(PostConstructPreDestroyLauncherApp.class)
				
				){
			//Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

		}
	}

}
