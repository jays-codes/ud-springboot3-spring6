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
	
	@RequestMapping("hellohtml")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>to do application</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("body - todo application");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	//hello jsp
	//src\main\resources\META-INF\resources\WEB-INF\jsp\hello.jsp
	@RequestMapping("hellojsp")
	public String helloJsp() {
		return "hello";
	}
}
