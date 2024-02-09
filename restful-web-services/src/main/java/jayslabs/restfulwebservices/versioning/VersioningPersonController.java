package jayslabs.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public PersonV1 getV1Person() {
		return new PersonV1("Bob Belcher");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getV2Person() {
		return new PersonV2(new Name("Bob", "Belcher"));
	}
}
