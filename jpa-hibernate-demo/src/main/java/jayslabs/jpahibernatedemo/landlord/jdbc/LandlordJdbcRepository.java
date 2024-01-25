package jayslabs.jpahibernatedemo.landlord.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jayslabs.jpahibernatedemo.landlord.Landlord;

@Repository
public class LandlordJdbcRepository {

	@Autowired
	private JdbcTemplate template;

	private static String SELECT_QUERY = """
			 select * from landlord where id=?;
			""";
	
	private static String INSERT_QUERY = """
			insert into landlord(id, name, prop)
			values(?, ?, ?);
			""";

	private static String DELETE_QUERY = """
			 delete from landlord where id=?;
			""";

	public Landlord findById(long id) {
		return template.queryForObject(
				SELECT_QUERY, 
				new BeanPropertyRowMapper<>(Landlord.class), id);
	}
	
	public void insert(Landlord ll) {
		template.update(
				INSERT_QUERY, 
				ll.getId(), 
				ll.getName(), 
				ll.getProp());
	}
	
	public void deleteById(long id) {
		template.update(DELETE_QUERY, id);
	}
}
