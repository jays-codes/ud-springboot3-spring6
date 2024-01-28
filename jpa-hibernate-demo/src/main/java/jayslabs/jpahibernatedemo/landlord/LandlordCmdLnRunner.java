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
		repo.save(new Landlord(4,"Chopah","Property X12345128"));
		repo.save(new Landlord(2,"Luffy","Property X12467348"));
		repo.save(new Landlord(3,"Robeen","Property X12591568"));
		repo.save(new Landlord(5,"Sanji","Property S12491228"));
		repo.save(new Landlord(6,"Zoro","Property S777777"));

		
		repo.deleteById(2l);
		System.out.println(repo.findById(3l));
		
		System.out.println(repo.findByName("Sanji"));
//		Landlord ll = repo.findById(3l);
		System.out.println("count: " + repo.count());
	}

}
