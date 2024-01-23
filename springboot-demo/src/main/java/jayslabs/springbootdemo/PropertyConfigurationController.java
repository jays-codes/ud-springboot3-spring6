package jayslabs.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyConfigurationController {
	
	@Autowired
	private PropertyServiceConfiguration config;
	
	@RequestMapping("/property-configuration")	
	public PropertyServiceConfiguration retrievePropertyServiceConfiguration(){
		return this.config;
	}
}
