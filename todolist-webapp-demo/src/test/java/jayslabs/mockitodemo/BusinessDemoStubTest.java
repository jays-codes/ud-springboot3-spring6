package jayslabs.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusinessDemoStubTest {

	@Test
	void test() {
		DataServiceStub stub = new DataServiceStub();
		BusinessDemo bsns = new BusinessDemo(stub);
		System.out.println("max: " + bsns.findGreatest());
	}

}

class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		return new int[]{25,12,13,16,17,10,32,56,87};
	}
	
}
