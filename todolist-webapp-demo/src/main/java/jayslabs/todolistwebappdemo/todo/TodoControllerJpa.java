package jayslabs.todolistwebappdemo.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	public TodoControllerJpa(TodoService todosrvc, TodoRepository repo) {
		super();
		this.repo = repo;
	}

	private TodoRepository repo;
	
	@RequestMapping("welcome")
	public String gotoWelcomPage(ModelMap map) {
		return "welcome";
	}

	
	@RequestMapping("listtodos")
	public String listAllTodos(ModelMap map) {
		String name = (String) map.get("name");
		List<Todo> todos =  repo.findByUsername(name);
		map.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping("addtodo")
	public String showAddTodoPage(ModelMap model) {
		String user = (String) model.get("name");
		Todo todo = new Todo(0, user,"",LocalDate.now(), false);
		model.put("todo",todo);
		return "addtodo";
	}
	
	@RequestMapping("updatetodo")
	public String showUpdateTodoPage(ModelMap map, @RequestParam int id) {
		Todo todo = repo.findById(id).get();
		map.put("todo",todo);
		return "addtodo";
	}
	
	@RequestMapping(value="addtodo", method=RequestMethod.POST)
	public String addTodo(ModelMap map, @Valid Todo todo, BindingResult bres) {
		
		if(bres.hasErrors()) {
				return "addtodo";
		}
		
		repo.save(todo);
		return "redirect:listtodos";
	}

	@RequestMapping(value="updatetodo", method=RequestMethod.POST)
	public String updateTodo(ModelMap map, @Valid Todo todo, BindingResult bres) {
		
		if(bres.hasErrors()) {
				return "addtodo";
		}
		
		todo.setIsNew(false);
		repo.save(todo);
		return "redirect:listtodos";
	}

	
	@RequestMapping(value="deletetodo")
	public String deleteTodo(@RequestParam int id) {
		repo.deleteById(id);
		return "redirect:listtodos";
	}
	
}
