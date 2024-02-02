package jayslabs.todolistwebappdemo.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.Authentication;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	@Autowired
//	private AuthenticationService authSrvc;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String goToWelcomePage(ModelMap map) {
		
		map.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	
	private String getLoggedinUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String goToWelcome(@RequestParam String name, @RequestParam String pwd, ModelMap map) {
//		
//		if (authSrvc.authenticate(name, pwd)) {
//			map.put("name", name);
//			return "welcome";			
//		} else {
//			map.put("error", "wrong username and-or password");
//			return "login";
//		}
//	}
}
