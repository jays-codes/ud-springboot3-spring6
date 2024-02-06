package jayslabs.todolistwebappdemo.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;

@Entity(name="todo")
public class Todo {
	@Id
	@GeneratedValue
	private int id;
	private String username;
	
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Transient
    private boolean isNew = true;

	public boolean isNew() {
		return isNew;
	}


	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}


	@Size(min=10, message="Enter at least 10 chars")
	private String description;
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate targetDate;
	private boolean done;
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;		
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
}
