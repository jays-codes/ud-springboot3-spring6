package jayslabs.springaopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Before("execution(* jayslabs.springaopdemo.*.*.*(..))")
	public void logMethodCall(JoinPoint joinpt) {
		logger.info("Before Aspect - {} is called with args: {}", 
				joinpt, joinpt.getArgs());
	}

	@After("execution(* jayslabs.springaopdemo.*.*.*(..))")
	public void logMethodCallAfterExecution(JoinPoint joinpt) {
		logger.info("After Execution Aspect - {} has executed.", joinpt);
	}

	@AfterReturning(
			pointcut="execution(* jayslabs.springaopdemo.*.*.*(..))",
			returning="resultVal"
			)
	public void logMethodCallAfterSuccessExecution(JoinPoint joinpt, Object resultVal) {
		logger.info("AfterReturn Aspect - {} has returned {}", joinpt, resultVal);
	}
	
	@AfterThrowing(
			pointcut="execution(* jayslabs.springaopdemo.*.*.*(..))",
			throwing="exception"
			)
	public void logMethodCallAfterException(JoinPoint joinpt, Exception exception) {
		logger.info("AfterThrowing Execution Aspect - {} has thrown an exception {}", 
				joinpt, exception);
	}
}
