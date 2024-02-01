package jayslabs.todolistwebappdemo.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class Todo {
	private int id;
	private String todoname;
	
	@Size(min=10, message="Enter at least 10 chars")
	private String description;
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate targetDate;
	private boolean done;
	
	public Todo(int id, String todoname, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.todoname = todoname;		
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", todoname=" + todoname + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTodoname() {
		return todoname;
	}

	public void setTodoname(String todoname) {
		this.todoname = todoname;
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


}
