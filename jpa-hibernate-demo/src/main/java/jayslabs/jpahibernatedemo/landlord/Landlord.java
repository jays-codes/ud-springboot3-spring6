package jayslabs.jpahibernatedemo.landlord;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="landlord")
public class Landlord {
	
	@Id
	private long id;
	private String name;
	private String prop;
	
	public Landlord() {

	}

	public Landlord(long id, String name, String prop) {
		super();
		this.id = id;
		this.name = name;
		this.prop = prop;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProp(String prop) {
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


}
