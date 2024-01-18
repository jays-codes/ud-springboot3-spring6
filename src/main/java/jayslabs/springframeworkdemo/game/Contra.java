package jayslabs.springframeworkdemo.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("chosengame")
public class Contra implements Game {

	@Override
	public void up() {
		System.out.println("jump up...");

	}

	@Override
	public void down() {
		System.out.println("crouch...");

	}

	@Override
	public void left() {
		System.out.println("left...");

	}

	@Override
	public void right() {
		System.out.println("right...");

	}

}

