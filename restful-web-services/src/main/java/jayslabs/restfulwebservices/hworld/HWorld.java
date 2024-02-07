package jayslabs.restfulwebservices.hworld;

public class HWorld {

	private String msg;
	
	@Override
	public String toString() {
		return "HWorld [msg=" + msg + "]";
	}

	public HWorld(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


}
