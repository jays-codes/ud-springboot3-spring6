package jayslabs.springframeworkdemo.exercise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("mongodb")
public class MongoDbDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] {11,22,33,44,55};
	}

}
