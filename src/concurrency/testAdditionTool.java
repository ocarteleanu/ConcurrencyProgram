package concurrency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * This JUnit test case verifies the function of the additionTool() method that adds to 
 * the initial value of the class variable arraySum the value 2 of any random element 
 * in the initial arrayOfNumbers array
 */
class testAdditionTool {
	
	@Test
	void test() {	
		ConcurrencyAssignment.arraySum = 4;
		for(int i = 0; i < 200000000; i ++) {
			ConcurrencyAssignment.arrayOfNumbers[i] = 2;
		}
		ConcurrencyAssignment.additionTool(2000);
		assertEquals(6, ConcurrencyAssignment.arraySum);
	}

}
