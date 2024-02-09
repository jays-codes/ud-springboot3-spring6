package jayslabs.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDAOService dao;

	public UserResource(UserDAOService dao) {
		this.dao = dao;
	}

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return dao.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = dao.findById(id);
		if (user==null) throw new UserNotFoundException("id: "+id);
		return user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User savedUser = dao.save(user);
		
		URI loc=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(loc).build();
	}
	
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		User user = retrieveUser(id);
		dao.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
