package concurrency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * This JUnit test case verifies the function of the oddNumbersSum() of the 
 * ParallelSumCalculation class. It is supposed to add only the odd numbers to the arraySum 
 * class 
 */
class testOddNumbersSum {

	@Test
	void test() {
		ConcurrencyAssignment.arraySum = 4;
		for(int i = 0; i < 200000000; i ++) {
			ConcurrencyAssignment.arrayOfNumbers[i] = 1;
		}
		ParallelSumCalculation parallelSumCalculation = new ParallelSumCalculation(true);
		parallelSumCalculation.oddNumbersSum();
		assertEquals(200000004, ConcurrencyAssignment.arraySum);
	}

}
