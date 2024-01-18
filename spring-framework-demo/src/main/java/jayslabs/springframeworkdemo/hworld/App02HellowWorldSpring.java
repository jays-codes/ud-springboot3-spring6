package jayslabs.springframeworkdemo.hworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HellowWorldSpring {

	public static void main(String[] args) {

		//Launch a Spring Context
		//use try with resources - to automatically close context if something happens
		try(		
			var context = new AnnotationConfigApplicationContext(HWorldConfiguration.class)
){
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("crib"));
			System.out.println(context.getBean(Person.class));
			System.out.println(context.getBean(Address.class));
			System.out.println(context.getBean("manager"));
			System.out.println(context.getBean("emergencycontact"));

			//using Streams, method reference
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
		}
		
		//Configure items(bean) to be managed by spring
		//in context config
		
	}

}
