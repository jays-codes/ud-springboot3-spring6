package jayslabs.jpahibernatedemo.landlord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LandlordCmdLnRunner implements CommandLineRunner{

	@Autowired
	private LandlordJpaRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.insert(new Landlord(4,"Chopah","Property X1234512"));
		repo.insert(new Landlord(2,"Luffy","Property X1246734"));
		repo.insert(new Landlord(3,"Robeen","Property X1259156"));
		
		repo.deleteById(2);
		Landlord ll = repo.findById(3);
		System.out.println(ll);
	}

}
