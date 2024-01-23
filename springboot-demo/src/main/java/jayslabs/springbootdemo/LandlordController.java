package jayslabs.springbootdemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8082/landlords
//[
// {
//	 "id": 1,
//	 "name": "Jay Menorca",
//	 "prop": "4 Park"
// }
// ]

@RestController
public class LandlordController {
	
	@RequestMapping("/landlords")
	public List<Landlord> retrieveAllLandlords(){
		return Arrays.asList(
				new Landlord(1,"Jay Menorca", "4 Victoria Rd"),
				new Landlord(2,"Saitam Jo", "123 Tokyo-Tokyo!"),
				new Landlord(3,"Gintamaaa", "125 Tokyo-Tokyo!")

				);
	}
}
