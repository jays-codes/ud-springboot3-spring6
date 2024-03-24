package jayslabs.springaopdemo.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import jayslabs.springaopdemo.data.DataService;

@Service
public class BusinessService {
	public BusinessService(DataService datasrvc) {
		super();
		this.datasrvc = datasrvc;
	}

	private DataService datasrvc;
	
	public int calculateMax() {
		int[] nums = datasrvc.retrieveData();
		
		//throw new RuntimeException("Something went wrong...");
		
		return Arrays.stream(nums).max().orElse(0);
	}
}
