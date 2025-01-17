package incubyte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void shouldReturn0OnEmptyString() {
		assertEquals(0, Calculator.sum(""));
	}
	
	@Test
	public void shouldWorkWithSingleNumber() {
		assertEquals(3, Calculator.sum("3"));
	}
	
	@Test
	public void shouldAddMultipleNumbersWithCommaDelimiter() {
		assertEquals(6, Calculator.sum("3,3"));
		assertEquals(9, Calculator.sum("3,3,3"));
	}
	
	@Test
	public void shouldWorkWithNewLineAsDelimiter() {
		assertEquals(9, Calculator.sum("3\n3\n3"));
	}
	
	@Test
	public void shouldWorkWithCustomDelimiter() {
		assertEquals(3, Calculator.sum("//;\n1;2"));
	}
	
	@Test
	public void shouldWorkWithCustomDelimiterOfLength() {
		assertEquals(6, Calculator.sum("//--\n1--2--3"));
	}
	
	@Test
	public void shouldNotAllowNegativeNumbers() {
		try {
			Calculator.sum("1,2,-3");
		}catch (RuntimeException ex){
			assertEquals("negative numbers not allowed -3", ex.getMessage());
		}
	}
	
	@Test
	public void shouldNotAllowMultipleNegativeNumbers() {
		try {
			Calculator.sum("1,-2,-3");
		}catch (RuntimeException ex){
			assertEquals("negative numbers not allowed -3", ex.getMessage());
		}
	}
}
