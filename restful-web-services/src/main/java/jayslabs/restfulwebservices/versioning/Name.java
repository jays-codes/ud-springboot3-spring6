package jayslabs.restfulwebservices.versioning;

public class Name {
	@Override
	public String toString() {
		return "Name [first=" + first + ", last=" + last + "]";
	}

	public Name(String first, String last) {
		super();
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	private String first;
	private String last;
}
