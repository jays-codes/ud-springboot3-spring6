package jayslabs.todolistwebappdemo.login;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jayslabs.todolistwebappdemo.todo.Todo;
import jayslabs.todolistwebappdemo.todo.TodoService;

@Controller
public class TodoController {
	
	public TodoController(TodoService todosrvc) {
		super();
		this.todosrvc = todosrvc;
	}

	
	private TodoService todosrvc;
	
	@RequestMapping("listtodos")
	public String listAllTodos(ModelMap map) {
		List<Todo> todos =  todosrvc.findByUsername("all");
		map.addAttribute("todos", todos);
		return "listTodos";
	}
	
}
