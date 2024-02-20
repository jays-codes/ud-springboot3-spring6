package jayslabs.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties("fld2")
@JsonFilter("BeanAFilter")
public class BeanA {
	private String fld1;
	private String fld2;
	
	//@JsonIgnore
	private String fld3;

	@Override
	public String toString() {
		return "BeanA [fld1=" + fld1 + ", fld2=" + fld2 + ", fld3=" + fld3 + "]";
	}

	public BeanA(String fld1, String fld2, String fld3) {
		super();
		this.fld1 = fld1;
		this.fld2 = fld2;
		this.fld3 = fld3;
	}

	public String getFld1() {
		return fld1;
	}

	public String getFld2() {
		return fld2;
	}

	public String getFld3() {
		return fld3;
	}

}
