package jayslabs.springaopdemo.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService {
	
	public int[] retrieveData() {
		return new int[] {12, 13,16,1,32,76,23};
	}
}
