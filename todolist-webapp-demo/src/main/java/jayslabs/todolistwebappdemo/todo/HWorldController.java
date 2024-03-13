package jayslabs.todolistwebappdemo.todo;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000", allowCredentials="true")
public class HWorldController {
	
	private MessageSource msgSource;
	
	public HWorldController(MessageSource msgSource) {
		this.msgSource = msgSource;
	}


	
	@GetMapping(path="/yow")
	public String helloAction() {
		return "Wazzzzzz upppppp!!!";
	}
	
	@GetMapping(path="/yowbean")
	public HWorld getHelloBean() {
		return new HWorld("Imma Bean Yow!...uhmm... I'm being called from React...");
	}
	
	@GetMapping(path="/hello/pathparam/{name}")
	public HWorld getHelloWithPathVar(@PathVariable String name) {
		return new HWorld("Imma Bean Yow! Yo React! Ma nem is: " + name);
	}
	
	@GetMapping(path="/hello-i18n")
	public HWorld getHelloWithPathVar() {
		Locale locale = LocaleContextHolder.getLocale();
		
		String hello = msgSource.getMessage("hello.message", null, "Default Message", locale);
		return new HWorld(hello + "! Imma Bean Yow! World!!!");
	}
}
