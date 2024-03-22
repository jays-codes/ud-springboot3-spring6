package jayslabs.springsecuritydemo.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TodoResource {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final List<Todo> TODOS_LIST = List.of(
			new Todo("jaymenorca", "Learn SpringBoot 5"),
			new Todo("jaymenorca", "Learn Springd Data JPA"),
			new Todo("jaymenorca", "Learn SpringBoot Microservices"),
			new Todo("jaymenorca", "Learn SpringBoot/Kafka")
			);

	@GetMapping("/todos")
	public List<Todo> retrieveAllTodos() {
		return TodoResource.TODOS_LIST;
	}
 
	@GetMapping("/users/{user}/todos")
	public Todo retrieveTodosForUser(@PathVariable String user){
		return TodoResource.TODOS_LIST.get(0);		
	}
	
	@PostMapping("/users/{user}/todos")
	public void addTodoForUser(@PathVariable String user, @RequestBody Todo todo) {
		logger.info("create {} for {}", todo, user);
	}
	
	@GetMapping("/hworld")
	public String hiWorld() {
		return "wazzaaaaaap!!!";
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}
}

record Todo(String user, String desc) {}