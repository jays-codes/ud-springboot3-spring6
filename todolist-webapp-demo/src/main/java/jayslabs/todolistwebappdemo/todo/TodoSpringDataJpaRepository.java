package jayslabs.todolistwebappdemo.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoSpringDataJpaRepository extends JpaRepository<Todo, Integer> {
	//List<Todo> findByName(String username);
	
}
