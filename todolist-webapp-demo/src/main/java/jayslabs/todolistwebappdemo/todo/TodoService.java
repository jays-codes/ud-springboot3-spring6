package jayslabs.todolistwebappdemo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
}
