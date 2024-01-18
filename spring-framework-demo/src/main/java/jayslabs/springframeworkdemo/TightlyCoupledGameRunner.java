package jayslabs.springframeworkdemo;

import jayslabs.springframeworkdemo.game.MarioGame;

public class TightlyCoupledGameRunner {

	MarioGame game;
	
	public TightlyCoupledGameRunner(MarioGame game) {
		this.game=game;
	}

	public void run() {
		System.out.println("Running game:" + game);
		game.up();
		game.down();
	}
	
}
