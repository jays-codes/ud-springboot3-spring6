package jayslabs.springaopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());	
	
	@Around("jayslabs.springaopdemo.aspect.CommonPointcutConfig.annoConfig()")
	public Object findExecutionTime(ProceedingJoinPoint pjpt) throws Throwable {
		//start timer
		long startTime = System.currentTimeMillis();
		
		//execute method
		Object retval = pjpt.proceed();
		
		//stop timer
		long stopTime = System.currentTimeMillis();
		long duration = stopTime - startTime;
		
		logger.info("Around Aspect - {} Method executed in {} ms",pjpt ,duration);
		return retval;
	}
}
