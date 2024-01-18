package jayslabs.springframeworkdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HellowWorldSpring {

	public static void main(String[] args) {

		//Launch a Spring Context
		var context = new AnnotationConfigApplicationContext(HWorldConfiguration.class);
		
		//Configure items(bean) to be managed by spring
		//in context config
		
		//use bean
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("address"));

	}

}
