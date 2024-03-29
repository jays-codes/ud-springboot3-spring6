package jayslabs.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
//findalluser, save, finduser
	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;

	static {
		users.add(new User(++userCount, "jay", LocalDate.now().minusYears(47)));
		users.add(new User(++userCount, "ethan", LocalDate.now().minusYears(15)));
		users.add(new User(++userCount, "sette", LocalDate.now().minusYears(40)));
	}
	
	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public User findById(int id) {
		// Todo td = todos.stream().filter(t ->
		// t.getId()==id).findFirst().get();//.orElse(null);

		User user = users.stream().filter(u -> u.getId().equals(id))
				.findFirst().orElse(null);
		return user;
	}

	public void deleteById(int id) {
		users.removeIf(u-> u.getId().equals(id));
	}

}
