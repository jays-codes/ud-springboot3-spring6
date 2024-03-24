package jayslabs.springaopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	//pointcut - when
	@Before("execution(* jayslabs.springaopdemo.*.*.*(..))")
	public void logMethodCall(JoinPoint joinpt) {
		logger.info("Before Aspect - Method called: {}", joinpt);
	}
}
