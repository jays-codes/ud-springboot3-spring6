package jayslabs.mockitodemo;

interface DataService{
	int[] retrieveAllData();
}
public class BusinessDemo {
	
	public BusinessDemo(DataService srvc) {
		super();
		this.srvc = srvc;
	}

	private DataService srvc;
	
	public int findGreatest() {
		int[] data = srvc.retrieveAllData();
		int greatestVal = Integer.MIN_VALUE;
		for (int val:data) {
			if (val>greatestVal) greatestVal = val;
		}
		return greatestVal;
	}
}
