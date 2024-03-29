package jayslabs.todolistwebappdemo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
//	@Autowired
//	private static TodoRepository repo;
	
	private static List<Todo> todos = new ArrayList<Todo>();
	static{
//		todos.add(new Todo(1,"jaymenorca", "Learn Spring",
//				LocalDate.now().plusWeeks(2), false));
//		todos.add(new Todo(2,"jaymenorca", "Learn SpringBoot",
//				LocalDate.now().plusWeeks(4), false));
//		todos.add(new Todo(3,"jaymenorca", "Learn SpringJPA",
//				LocalDate.now().plusWeeks(5), false));
//		todos.add(new Todo(4,"jaymenorca", "Learn SpringBoot Microservices",
//				LocalDate.now().plusWeeks(7), false));
//		todos.add(new Todo(5,"jaymenorca", "Learn Apache Kafka Rabbit MQ",
//				LocalDate.now().plusWeeks(8), false));
//		repo.save(new Todo(1,"jaymenorca", "Learn Spring",
//				LocalDate.now().plusWeeks(2), false));
//		repo.save(new Todo(2,"jaymenorca", "Learn SpringBoot",
//				LocalDate.now().plusWeeks(4), false));
//		repo.save(new Todo(3,"jaymenorca", "Learn SpringJPA",
//				LocalDate.now().plusWeeks(5), false));
//		repo.save(new Todo(4,"jaymenorca", "Learn SpringBoot Microservices",
//				LocalDate.now().plusWeeks(7), false));
//		repo.save(new Todo(5,"jaymenorca", "Learn Apache Kafka Rabbit MQ",
//				LocalDate.now().plusWeeks(8), false));

	}
	
	public List<Todo> findByUsername(String name) {

		List<Todo> tds = todos.stream().filter(t -> t.getUsername().equalsIgnoreCase(name)).toList();
		//List<Todo> tds = repo.findByName(name);
		
		return tds;
	}
	
//	public Todo createToDo(String desc) {
//		String todoname = desc.replaceAll("\\s","");
//		
//		Todo newtd = new Todo(
//				createId(), todoname, desc,LocalDate.now().plusWeeks(1), false);
//		return newtd;
//	}
	
	private int createId() {
		List<Integer> ids = todos.stream()
				.map(Todo::getId)
				.collect(Collectors.toList());
		
		Integer top = Collections.max(ids);
		return top.intValue()+1;
	}

	public void addTodo(Todo todo) {
		String desc = todo.getDescription();
		String user = todo.getUsername();
		Todo newtd = new Todo(
				createId(), user, desc,todo.getTargetDate(), false);
		
		//repo.save(newtd);
		todos.add(newtd);
	}

	public void deleteToDo(int id) {
		//checks if id is present in the list
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		todos.removeIf(predicate);
		//repo.deleteById(id);
	}

	public Todo retrieveToDo(int id) {
		Todo td = todos.stream().filter(t -> t.getId()==id).findFirst().get();//.orElse(null);
		//Todo td = repo.findById(id).get();
		return td;
	}

	public void updateTodo(@Valid Todo todo) {
		Todo origtd = retrieveToDo(todo.getId());
		origtd.setDescription(todo.getDescription());
		origtd.setTargetDate(todo.getTargetDate());
//		todo.setIsNew(false);
//		repo.save(todo);
	}
	
}
