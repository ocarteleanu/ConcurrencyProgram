package concurrency;
/**
 * The ConcurrencyAssignment class is used to call the constructor of the threads that will
 * work in parallel and the constructor of the thread that will work by itself to sum up the
 * numbers in the array. It will also display messages about the sum calculated with the two 
 * methods and the time in nanoseconds that each process uses to finish the task. 
 */
public class ConcurrencyAssignment {
	/**
	 * arrayOfNumbers is an array with 200 million integers from 1 to 10
	 * arraySum is the variable that will store the sum calculated in parallel
	 * arraySumToCompare is the variable that will store the sum calculated by a single thread
	 */
	protected static int[] arrayOfNumbers = new int[(int) (2*Math.pow(10, 8))];
	protected static int arraySum = 0;  	
	protected static int arraySumToCompare = 0; 
	/**
	 * This synchronized method is used to calculate the sum in parallel being called by the
	 * run() method in the parallel threads
	 * @param theIndex is an integer that is passed as an argument and represents the
	 * index of the number in the array that is summed up by the parallel threads. This method 
	 * can only be used by a thread at a time
	 */
	public static synchronized void additionTool(int theIndex) {		
		ConcurrencyAssignment.arraySum += arrayOfNumbers[theIndex];		
	}
	/**
	 * This object represents a thread that will count by itself the sum of the 
	 * element of the array to compare the efficiency with the parallel calculation. 
	 * It implements the Runnable interface.  
	 */
    static Thread singleThread = new Thread (new Runnable() {
		@Override
		public void run() {	
			System.out.println("The single thread has started...");
			sumCalculation();
		    System.out.println("The sum of the elements in the array "
		    		+ "calculated with one thread is: " 
		    	    + ConcurrencyAssignment.arraySumToCompare);
			}	
		public void sumCalculation() {
			for(int i = 0; i < ConcurrencyAssignment.arrayOfNumbers.length; i ++) {
			ConcurrencyAssignment.arraySumToCompare += 
					ConcurrencyAssignment.arrayOfNumbers[i];
			}	
		}
    });
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		for(int j = 0; j < arrayOfNumbers.length; j ++) {
			arrayOfNumbers[j] = (int)(Math.random()*10 + 1); 
		}
	    /**
	     * Creating and starting the parallel threads
	     */
		ParallelSumCalculation threadOne = new ParallelSumCalculation(true);
		ParallelSumCalculation threadTwo = new ParallelSumCalculation(false);
		/**
		 * all the long variables declared below are used to count the time 
		 * in nanoseconds of the process
		 */
		long startMultithreadTask = System.nanoTime();
		threadOne.start();
		threadTwo.start();
		/**
		 * Joining the parallel threads to the main thread
		 */
		try {
			threadOne.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			threadTwo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The sum of the elements in the array calculated"
				+ " with multi-threading is: " + arraySum);
		long endMultithreadTask = System.nanoTime();
		System.out.println("The time of calculation with multi-threading"
				+ " was: " + (endMultithreadTask - startMultithreadTask) + " nanoseconds");
				

	    long startSinglethreadTask = System.nanoTime();	 
	    //the program take a 3 seconds break between the multi-thread and single thread
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    /**
	     * Starting the single thread
	     */
	    singleThread.start();	  
	    try {
			singleThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    long endSinglethreadTask = System.nanoTime();
		System.out.println("The time of calculation with single-threading"
				+ " was: " + (endSinglethreadTask - startSinglethreadTask) + " nanoseconds");
		System.out.println("The single-thread was " + ((endMultithreadTask - startMultithreadTask)
				- (endSinglethreadTask - startSinglethreadTask)) / Math.pow(10, 9) +
				" seconds faster than " + "the multi-thread");
	}

}
