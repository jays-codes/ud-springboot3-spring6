package jayslabs.springbootdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//property-service.id=
//property-service.name=
//property-service.addr=

@ConfigurationProperties(prefix = "property-service")
@Component
public class PropertyServiceConfiguration {
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	private String id;
	private String name;
	private String type;
}
