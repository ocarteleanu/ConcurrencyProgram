package concurrency;
/**
 * This class is used to create threads to calculate the sum of the numbers 
 * in an array in parallel. Each thread will have a boolean data field that will 
 * determine if the thread will sum up the even integers (is the boolean isEven has a true value)
 * or the odd integers (if the boolean has a false value)
 */
public class ParallelSumCalculation extends Thread {
	boolean isEven;
	
	ParallelSumCalculation (boolean trueOrFalse){
		this.isEven = trueOrFalse;
	}
	

	@Override
	public void run() {		
		if(this.isEven)
			evenNumbersSum();
		else
			oddNumbersSum();
	}
	/**
	 * The evenNumbersSum method calculates the sum of all the even integers in the array
	 * by calling the static method additionTool() from the ConcurrencyAssignment class.
	 * It takes no parameters. Also, it displays a message after the thread that it belongs to,
	 * has started
	 */
	public void evenNumbersSum() {
		System.out.println("The even numbers thread has started...");
		for(int a = 0; a < ConcurrencyAssignment.arrayOfNumbers.length; a ++) {
			if(ConcurrencyAssignment.arrayOfNumbers[a] % 2 == 0) {
				ConcurrencyAssignment.additionTool(a);				
			}
		}
	}
	/**
     * The oddNumbersSum method calculates the sum of all the odd integers in the array
	 * by calling the static method additionTool() from the ConcurrencyAssignment class.
	 * It takes no parameters. Also, it displays a message after the thread that it belongs to,
	 * has started
 */
	public void oddNumbersSum() {
		System.out.println("The odd numbers thread has started...");
		for(int a = 0; a < ConcurrencyAssignment.arrayOfNumbers.length; a ++) {
			if(ConcurrencyAssignment.arrayOfNumbers[a] % 2 != 0) {
				ConcurrencyAssignment.additionTool(a);					
			}
		}
	}
		
}
