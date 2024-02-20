package jayslabs.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import jayslabs.restfulwebservices.user.jpa.UserRepository;

@RestController
public class UserJpaResource {

	private UserRepository repo;

	public UserJpaResource(UserRepository repo) {
		this.repo = repo;
	}

	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return repo.findAll();
	}
	
	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = repo.findById(id);
		if (user.isEmpty()) throw new UserNotFoundException("id: "+id);
		
		EntityModel<User> emod = EntityModel.of(user.get());
		WebMvcLinkBuilder link = 
				linkTo(methodOn(this.getClass())
						.retrieveAllUsers());
		emod.add(link.withRel("all-users"));
		
		return emod;
	}
	
	@PostMapping(path="/jpa/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User savedUser = repo.save(user);
		
		URI loc=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(loc).build();
	}
	
	@DeleteMapping(path = "/jpa/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		EntityModel<User> user = retrieveUser(id);
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
