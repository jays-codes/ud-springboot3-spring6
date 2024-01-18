package jayslabs.springframeworkdemo.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("mario")
public class MarioGame implements Game {
	public void up() {
		System.out.println("Jump");
	}

	public void down() {
		System.out.println("lie on floor");
	}

	public void left() {
		System.out.println("Running left...");
	}

	public void right() {
		System.out.println("Running right...");
	}

}
