package jayslabs.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BusinessDemoMockTest {

	@Mock
	private DataService dsmock;
	
	@InjectMocks
	private BusinessDemo bsns;
	
	@Test
	void findGreatest_Scenario1() {
		
		when(dsmock.retrieveAllData())
		.thenReturn(new int[]{25,12,13,16,17,10,32,56,87});
		
		int res = bsns.findGreatest();
		assertEquals(87, res);
		System.out.println("max: " + res);
		
	}

}


