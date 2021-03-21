package concurrency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * This JUnit test case verifies the function of the evenNumbersSum() of the 
 * ParallelSumCalculation class. It is supposed to add only the even numbers to the arraySum 
 * class 
 */
class testEvenNumbersSum {

	@Test
	void test() {
		ConcurrencyAssignment.arraySum = 4;
		for(int i = 0; i < 200000000; i ++) {
			ConcurrencyAssignment.arrayOfNumbers[i] = 2;
		}
		ParallelSumCalculation parallelSumCalculation = new ParallelSumCalculation(true);
		parallelSumCalculation.evenNumbersSum();
		assertEquals(400000004, ConcurrencyAssignment.arraySum);
	}

}
