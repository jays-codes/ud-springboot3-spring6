package jayslabs.jpahibernatedemo.landlord;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LandlordSpringDataJpaRepository extends JpaRepository<Landlord, Long> {
	List<Landlord> findByName(String name);
	
}
