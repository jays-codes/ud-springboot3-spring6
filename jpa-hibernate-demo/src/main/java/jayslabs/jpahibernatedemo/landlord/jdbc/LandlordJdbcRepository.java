package jayslabs.jpahibernatedemo.landlord.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LandlordJdbcRepository {
	
	@Autowired
	private JdbcTemplate template;
	
	private static String INSERT_QUERY = 
			"""
			insert into landlord(id, name, prop)
			values(3, 'Saitama Jo', '123 Toaru shi');
			""";
	
	public void insert() {
		template.update(this.INSERT_QUERY);
	}
}
