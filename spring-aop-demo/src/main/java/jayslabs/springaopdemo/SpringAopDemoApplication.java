package jayslabs.springaopdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jayslabs.springaopdemo.business.BusinessService;

@SpringBootApplication
public class SpringAopDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private BusinessService bussrvc;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Value: {}",bussrvc.calculateMax());
	}

	public SpringAopDemoApplication(BusinessService bussrvc) {
		super();
		this.bussrvc = bussrvc;
	}

}
