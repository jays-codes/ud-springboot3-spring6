package jayslabs.springaopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
	
	@Pointcut("execution(* jayslabs.springaopdemo.*.*.*(..))")
	public void allPackages() {}
	
	@Pointcut("bean(*Service*)")
	public void beanConfig() {}
	
	@Pointcut("@annotation(jayslabs.springaopdemo.annotation.TrackTime)")
	public void annoConfig() {}
}
