package incubyte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void shouldReturn0OnEmptyString() {
		assertEquals(0, Calculator.sum(""));
	}
	
	@Test
	public void shouldAddMultipleNumbers() {
		assertEquals(6, Calculator.sum("3,3"));
	}
}
