package jayslabs.jpahibernatedemo.landlord.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jayslabs.jpahibernatedemo.landlord.Landlord;

@Repository
public class LandlordJdbcRepository {

	@Autowired
	private JdbcTemplate template;

	private static String INSERT_QUERY = """
			insert into landlord(id, name, prop)
			values(?, ?, ?);
			""";

	private static String DELETE_QUERY = """
			 delete from landlord where(id=?);
			""";

	
	public void insert(Landlord ll) {
		template.update(
				INSERT_QUERY, 
				ll.getId(), 
				ll.getName(), 
				ll.getProp());
	}
	
	public void delete(long id) {
		template.update(DELETE_QUERY, id);
	}
}
