package jayslabs.springframeworkdemo.section4_3;

import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jayslabs.springframeworkdemo.game.GameRunner;

public class XMLConfigContextLauncherApp {

	public static void main(String[] args) {
		try(
				
			var ctx = new ClassPathXmlApplicationContext("ctxConfig.xml")
				){
			Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
		
			//System.out.println(ctx.getBean("name"));

			ctx.getBean(GameRunner.class).run();

		}
	}

}
