package jayslabs.jpahibernatedemo.landlord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LandlordCmdLnRunner implements CommandLineRunner{

//	@Autowired
//	private LandlordJdbcRepository repo;
	
//	@Autowired
//	private LandlordJpaRepository repo;

	@Autowired
	private LandlordSpringDataJpaRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Landlord(4,"Chopah","Property X1234512"));
		repo.save(new Landlord(2,"Luffy","Property X1246734"));
		repo.save(new Landlord(3,"Robeen","Property X1259156"));
		
		repo.deleteById(2l);
		System.out.println(repo.findById(3l));
		
//		Landlord ll = repo.findById(3l);
//		System.out.println(ll);
	}

}
