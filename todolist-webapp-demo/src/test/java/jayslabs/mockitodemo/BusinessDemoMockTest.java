package jayslabs.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class BusinessDemoMockTest {

	@Test
	void findGreatest_Scenario1() {
		DataService dsmock = mock(DataService.class);
		
		when(dsmock.retrieveAllData())
		.thenReturn(new int[]{25,12,13,16,17,10,32,56,87});
		
		BusinessDemo bsns = new BusinessDemo(dsmock);
		int res = bsns.findGreatest();
		assertEquals(87, res);
		System.out.println("max: " + res);
		
	}

}


