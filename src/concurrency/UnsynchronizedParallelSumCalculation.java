package concurrency;
/**
 * This class is used to create threads to calculate the sum of the numbers 
 * in an array in parallel. Each thread will have a boolean data field that will 
 * determine if the thread will sum up the even integers (is the boolean isEven has a true value)
 * or the odd integers (if the boolean has a false value)
 */
public class UnsynchronizedParallelSumCalculation extends Thread {
	int calculationSegment;
	
	UnsynchronizedParallelSumCalculation (int calculationIndex){
		this.calculationSegment = calculationIndex;
	}
	

	@Override
	public void run() {		
		unsynchronizedSum(calculationSegment);
	}
	/**
	 * The unsynchronizedSum method calculates the sum of all the numbers in the array
	 * by calling the static method alternativeAdditionTool() from the ConcurrencyAssignment class.
	 * It takes as parameter the class field calculationSegment. Also, it displays a 
	 * message after the thread that it belongs to, has started
	 */
	public void unsynchronizedSum(int computationIndex) {		
		if(computationIndex == 0) {
			System.out.println("The thread that calculates the "
					+ "first half of the sum of the"
					+ " elements in the array has started...");
			for(int i = 0; i <= 100000000; i++) {
				ConcurrencyAssignment.alternativeAdditionTool(i, computationIndex);
			}
		}
		else
		{
			System.out.println("The thread that calculates the second "
					+ "half of the sum of the"
					+ " elements in the array has started...");
			for(int i = 100000001; i < 200000000; i++) {
				ConcurrencyAssignment.alternativeAdditionTool(i, computationIndex);
			}
		}
	}
}
