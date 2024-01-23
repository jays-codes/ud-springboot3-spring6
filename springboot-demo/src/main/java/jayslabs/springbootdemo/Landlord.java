package jayslabs.springbootdemo;

public class Landlord {
	private long id;
	private String name;
	private String prop;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProp() {
		return prop;
	}

	public Landlord(long id, String name, String prop) {
		super();
		this.id = id;
		this.name = name;
		this.prop = prop;
	}

	@Override
	public String toString() {
		return "Landlord [id=" + id + ", name=" + name + ", prop=" + prop + "]";
	}
}
