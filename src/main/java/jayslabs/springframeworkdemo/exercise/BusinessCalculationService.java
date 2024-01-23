package jayslabs.springframeworkdemo.exercise;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BusinessCalculationService {
	DataService dataService;
	
//	public BusinessCalculationService(@Qualifier("mysql") DataService dataService) {
	public BusinessCalculationService(DataService dataService) {

		super();
		this.dataService = dataService;
	}

	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
}
