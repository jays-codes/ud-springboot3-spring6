package jayslabs.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	void test() {
		List listmock = mock(List.class);
		
		when(listmock.get(Mockito.anyInt())).thenReturn("anInteger");
		assertEquals("anInteger",listmock.get(4));

	}
}
