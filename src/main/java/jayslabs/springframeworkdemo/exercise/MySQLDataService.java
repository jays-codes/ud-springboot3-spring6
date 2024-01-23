package jayslabs.springframeworkdemo.exercise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mysql")
public class MySQLDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] {1,2,3,4,5};
	}

}
