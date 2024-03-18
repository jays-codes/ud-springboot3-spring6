package jayslabs.springsecuritydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HWorldResource {

	@GetMapping("/hworld")
	public String hiWorld() {
		return "wazzaaaaaap!!!";
	}
}
