package jayslabs.todolistwebappdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoitemController {
	
	@RequestMapping("hello")
	@ResponseBody
	public String sayHello() {
		return "Hello, what's up?";
	}
}
