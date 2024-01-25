package jayslabs.jpahibernatedemo.landlord;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LandlordJpaRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Landlord ll) {
		em.merge(ll);
	}
	
	public Landlord findById(long id) {
		return em.find(Landlord.class, id);
	}
	
	public void deleteById(long id) {
		Landlord ll = em.find(Landlord.class, id);
		em.remove(ll);
	}
}
