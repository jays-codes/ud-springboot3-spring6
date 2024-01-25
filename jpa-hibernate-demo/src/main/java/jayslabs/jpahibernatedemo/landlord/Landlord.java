package jayslabs.jpahibernatedemo.landlord;

import org.springframework.stereotype.Component;

public class Landlord {
	public Landlord() {

	}

	public Landlord(long id, String name, String prop) {
		super();
		this.id = id;
		this.name = name;
		this.prop = prop;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProp() {
		return prop;
	}

	@Override
	public String toString() {
		return "Landlord [id=" + id + ", name=" + name + ", prop=" + prop + "]";
	}

	private long id;
	private String name;
	private String prop;
}
