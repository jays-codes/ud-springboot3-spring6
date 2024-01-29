package jayslabs.todolistwebappdemo.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AuthenticationService authSrvc;
	
//	@RequestMapping("loginsample")
//	public String login(@RequestParam String name, ModelMap model) {
//		model.put("name", name);
//		logger.debug("Request param is {}", name);
//		return "login";
//	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String goToLogin() {
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String goToWelcome(@RequestParam String name, @RequestParam String pwd, ModelMap map) {
		
		if (authSrvc.authenticate(name, pwd)) {
			map.put("name", name);
			return "welcome";			
		} else {
			map.put("error", "wrong username and-or password");
			return "login";
		}
	}
}
