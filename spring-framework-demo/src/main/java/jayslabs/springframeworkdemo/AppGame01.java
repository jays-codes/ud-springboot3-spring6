package jayslabs.springframeworkdemo;

import jayslabs.springframeworkdemo.game.MarioGame;
import jayslabs.springframeworkdemo.game.PacMan;

public class AppGame01 {

	public static void main(String[] args) {

		//object creation
		//var game = new MarioGame();
		var game = new PacMan();
		
		//object creation; Dependency Wiring
		//Game is a dependency of GameRunner
		var gameRunner = new LooselyCoupledGameRunner(game);
		gameRunner.run();
	}

}
