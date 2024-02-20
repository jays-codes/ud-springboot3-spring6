package jayslabs.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		
		BeanA bean = new BeanA("val1", "val2", "val3");

		MappingJacksonValue mjv = filterBeanA(bean, "fld2", "fld3");

		return mjv;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {

		List<BeanA> beans = Arrays.asList(
				new BeanA("val1", "val2", "val3"),
				new BeanA("val4", "val5", "val6"),
				new BeanA("val7", "val8", "val9")
		);
		
		MappingJacksonValue mjv = filterBeanA(beans, "fld1", "fld2");

		return mjv;
	}
	
	private MappingJacksonValue filterBeanA(Object bean, String... fields) {
		MappingJacksonValue mjv = new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
		FilterProvider filters = new SimpleFilterProvider().addFilter("BeanAFilter", filter);
		mjv.setFilters(filters);
		return mjv;
	}
	

}
