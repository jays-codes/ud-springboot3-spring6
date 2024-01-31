package jayslabs.todolistwebappdemo.login;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jayslabs.todolistwebappdemo.todo.Todo;
import jayslabs.todolistwebappdemo.todo.TodoService;

@Controller
@SessionAttributes("name")
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
	
	@RequestMapping("addtodo")
	public String showAddTodoPage(ModelMap model) {
		Todo todo = todosrvc.createToDo("");
		model.put("todo",todo);
		return "addtodo";
	}
	
	@RequestMapping(value="addtodo", method=RequestMethod.POST)
	public String addTodo(ModelMap map, Todo todo) {
		
		todosrvc.addTodo(todo.getDescription());
		return "redirect:listtodos";
	}
	
}
