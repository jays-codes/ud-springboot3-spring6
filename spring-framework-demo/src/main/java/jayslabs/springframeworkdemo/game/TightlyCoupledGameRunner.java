package jayslabs.springframeworkdemo.game;

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
