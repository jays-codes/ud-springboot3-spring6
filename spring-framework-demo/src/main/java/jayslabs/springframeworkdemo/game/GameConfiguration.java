package jayslabs.springframeworkdemo.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class GameConfiguration {
	
	@Bean(name="mario")
	@Primary
	public Game game() {
		return new MarioGame();
	}
	
	@Bean
	//@Primary
	@Qualifier("chosengame")
	public Game game2() {
		return new PacMan();
	}
	
	@Bean
	public GameRunner gamerunner(@Qualifier("chosengame") Game game) {
		var runner = new GameRunner(game);
		return runner;
	}

}
