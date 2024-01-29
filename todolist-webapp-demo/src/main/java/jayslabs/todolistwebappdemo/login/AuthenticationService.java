package jayslabs.todolistwebappdemo.login;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

	public boolean authenticate(String name, String pwd) {
		boolean isValidName = name.equalsIgnoreCase("jaymenorca");
		boolean isValidPwd = pwd.equalsIgnoreCase("123456");
		return isValidName && isValidPwd;
	}
}
