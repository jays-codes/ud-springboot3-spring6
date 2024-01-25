package jayslabs.jpahibernatedemo.landlord.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LandlordJdbcCmdLnRunner implements CommandLineRunner{

	@Autowired
	private LandlordJdbcRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.insert();
		
	}

}
