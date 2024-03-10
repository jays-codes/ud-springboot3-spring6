package jayslabs.todolistwebappdemo.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

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

	@GetMapping("/users/{user}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String user,@PathVariable int id) {
		
		Optional<Todo> todo = repo.findById(id);
		return todo.get();
	}
	
	@DeleteMapping("/users/{user}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String user,@PathVariable int id) {
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/{user}/todos/{id}")
	public Todo updateTodo(@PathVariable String user,
			@PathVariable int id, @RequestBody @Valid Todo todo) {
		todo.setIsNew(false);
		repo.save(todo);
		return todo;
	}

	@PostMapping("/users/{user}/todos")
	public Todo createTodo(@PathVariable String user,
			@RequestBody @Valid Todo todo) {
		todo.setIsNew(true);
		repo.save(todo);
		return todo;
	}
	
}
