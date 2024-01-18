package jayslabs.springframeworkdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jayslabs.springframeworkdemo.game.Game;
import jayslabs.springframeworkdemo.game.GameConfiguration;
import jayslabs.springframeworkdemo.game.GameRunner;

public class AppGame2Spring {

	public static void main(String[] args) {

		try (var cxt = new AnnotationConfigApplicationContext(
				GameConfiguration.class)) {
			cxt.getBean(GameRunner.class).run();
			cxt.getBean(Game.class).down();
		}
	}

}
