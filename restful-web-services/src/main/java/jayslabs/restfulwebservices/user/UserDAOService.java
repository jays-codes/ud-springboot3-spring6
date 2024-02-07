package jayslabs.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDAOService {
//findalluser, save, finduser
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1,"jay", LocalDate.now().minusYears(47)));
		users.add(new User(2,"ethan", LocalDate.now().minusYears(15)));
		users.add(new User(3,"sette", LocalDate.now().minusYears(40)));

	}
	public List<User> findAll() {
		return users;
	}
	public User findById(int id) {
		//Todo td = todos.stream().filter(t -> t.getId()==id).findFirst().get();//.orElse(null);

		User user = users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
		// TODO Auto-generated method stub
		return user;
	}
	
	

}
