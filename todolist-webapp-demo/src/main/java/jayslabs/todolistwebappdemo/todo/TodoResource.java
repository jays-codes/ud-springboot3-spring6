package jayslabs.todolistwebappdemo.todo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000", allowCredentials="true")
public class TodoResource {
	
	public TodoResource(TodoRepository repo) {
		super();
		this.repo = repo;
	}

	private TodoRepository repo;
	
	
	@GetMapping("/users/{user}/todos")
	public List<Todo> retrieveUserTodos(@PathVariable String user) {
		List<Todo> todos =  repo.findByUsername(user);
		return todos;
	}
}
