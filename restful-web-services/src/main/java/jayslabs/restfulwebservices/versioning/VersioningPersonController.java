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
	
	@GetMapping(path="/person", params="version=1")
	public PersonV1 getV1PersonRequestParam() {
		return new PersonV1("Bob Belcher");
	}
	
	@GetMapping(path="/person", params="version=2")
	public PersonV2 getV2PersonRequestParam() {
		return getV2Person();
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=1")
	public PersonV1 getV1PersonReqHeaders() {
		return new PersonV1("Bob Belcher");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 getV2PersonReqHeaders() {
		return getV2Person();
	}

	@GetMapping(path="/person/accept", produces="application/json")
	public PersonV1 getV1PersonCN() {
		return new PersonV1("Bob Belcher CN");
	}
	
	@GetMapping(path="/person/accept", produces="application/v2+json")
	public PersonV2 getV2PersonCN() {
		return getV2Person();
	}
	
	@GetMapping(path="/person/accept", produces="application/v2+xml")
	public PersonV2 getV2PersonXMLCN() {
		return getV2Person();
	}
}
