package jayslabs.springframeworkdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jayslabs.springframeworkdemo.game.MarioGame;
import jayslabs.springframeworkdemo.game.PacMan;

public class App02HellowWorldSpring {

	public static void main(String[] args) {

		//Launch a Spring Context
		var context = new AnnotationConfigApplicationContext(HWorldConfiguration.class);
		
		//Configure items(bean) to be managed by spring
		//in context config
		
		//use bean
		System.out.println("bean: "+context.getBean("name"));
	}

}
