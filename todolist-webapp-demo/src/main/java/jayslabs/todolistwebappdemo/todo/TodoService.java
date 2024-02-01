package jayslabs.todolistwebappdemo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	static{
		todos.add(new Todo(1,"SpringFramework", "Learn Spring",
				LocalDate.now().plusWeeks(2), false));
		todos.add(new Todo(2,"SpringBoot", "Learn SpringBoot",
				LocalDate.now().plusWeeks(4), false));
		todos.add(new Todo(3,"SpringJPA", "Learn SpringJPA",
				LocalDate.now().plusWeeks(5), false));
		todos.add(new Todo(4,"SpringBootMicroservices", "Learn SpringBoot Microservices",
				LocalDate.now().plusWeeks(7), false));
		todos.add(new Todo(5,"KafkaRabbitMQ", "Learn Apache Kafka Rabbit MQ",
				LocalDate.now().plusWeeks(8), false));
	}
	
	public static List<Todo> findByUsername(String name) {
		return todos;
	}
	
	public Todo createToDo(String desc) {
		String todoname = desc.replaceAll("\\s","");
		
		Todo newtd = new Todo(
				createId(), todoname, desc,LocalDate.now().plusWeeks(1), false);
		return newtd;
	}
	
	private int createId() {
		List<Integer> ids = todos.stream()
				.map(Todo::getId)
				.collect(Collectors.toList());
		
		Integer top = Collections.max(ids);
		return top.intValue()+1;
	}

	public void addTodo(String description) {
		todos.add(this.createToDo(description));
	}

	public void deleteToDo(int id) {
		//checks if id is present in the list
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		todos.removeIf(predicate);
	}

	public Todo retrieveToDo(int id) {
		Todo td = todos.stream().filter(t -> t.getId()==id).findAny().orElse(null);
		return td;
	}

	public void updateTodo(@Valid Todo todo) {
		Todo origtd = retrieveToDo(todo.getId());
		origtd.setDescription(todo.getDescription());
	}
	
}
