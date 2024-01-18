package jayslabs.springframeworkdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jayslabs.springframeworkdemo.game.Game;
import jayslabs.springframeworkdemo.game.GameRunner;

@Configuration
@ComponentScan("jayslabs.springframeworkdemo.game")
public class AppGame2Spring {

	public static void main(String[] args) {

		try (var cxt = new AnnotationConfigApplicationContext(AppGame2Spring.class)) {
			cxt.getBean(GameRunner.class).run();
			cxt.getBean(Game.class).down();
		}
	}

	@Bean
	public GameRunner gamerunner(@Qualifier("chosengame") Game game) {
		var runner = new GameRunner(game);
		return runner;
	}

}
