package jayslabs.jpahibernatedemo.landlord.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jayslabs.jpahibernatedemo.landlord.Landlord;

@Component
public class LandlordJdbcCmdLnRunner implements CommandLineRunner{

	@Autowired
	private LandlordJdbcRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.insert(new Landlord(4,"Chopah","Property X123"));
		repo.insert(new Landlord(2,"Luffy","Property X124"));
		repo.insert(new Landlord(3,"Robeen","Property X125"));
		
		//repo.deleteById(2);
		Landlord ll = repo.findById(2);
		System.out.println(ll);
	}

}
