package jayslabs.springframeworkdemo.section4_2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
class BusinessService{

	public DataService getDataService() {
		return dataService;
	}

	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}

	private DataService dataService;
}

@Named
class DataService{
	
}

@Configuration
@ComponentScan
public class CDIContextLauncherApp {

	public static void main(String[] args) {
		try(
				
			var ctx = new AnnotationConfigApplicationContext(CDIContextLauncherApp.class)
				){
			Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(
					ctx.getBean(BusinessService.class).getDataService()
					);
		}
	}

}
