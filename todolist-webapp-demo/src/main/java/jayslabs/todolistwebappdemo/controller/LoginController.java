package jayslabs.todolistwebappdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
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
		map.put("name", name);
		//map.put("pwd", pwd);
		return "welcome";
	}
}
