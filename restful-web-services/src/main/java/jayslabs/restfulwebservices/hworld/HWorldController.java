package jayslabs.restfulwebservices.hworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HWorldController {
	
	@GetMapping(path="/yow")
	public String helloAction() {
		return "Wazzzzzz upppppp!!!";
	}
	
	@GetMapping(path="/yowbean")
	public HWorld getHelloBean() {
		return new HWorld("Imma Bean Yow!");
	}
	
	@GetMapping(path="/hello/pathparam/{name}")
	public HWorld getHelloWithPathVar(@PathVariable String name) {
		return new HWorld("Imma Bean Yow! Ma nem is: " + name);
	}
}
