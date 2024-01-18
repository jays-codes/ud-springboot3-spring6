package jayslabs.springframeworkdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jayslabs.springframeworkdemo.game.Game;
import jayslabs.springframeworkdemo.game.GameConfiguration;
import jayslabs.springframeworkdemo.game.GameRunner;

public class AppGame01 {

	public static void main(String[] args) {

		//object creation
		//var game = new MarioGame();
		//var game = new PacMan();
		
		var cxt = new AnnotationConfigApplicationContext(GameConfiguration.class);
		cxt.getBean(GameRunner.class).run();
		cxt.getBean(Game.class).down();
		//object creation; Dependency Wiring
		//Game is a dependency of GameRunner
		//var gameRunner = new GameRunner(game);
		//gameRunner.run();
	}

}
