/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: 100,000 times
  n=1       time: 16 nanosecs
  n=10      time: 805 nanosecs
  n=100     time: 7,748 nanosecs
  n=1000    time: 98,542 nanosecs
  ...
  n=<huge>  time: 

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{

    //create an array
    public static int[] generate(int size){
	int[] bois = new int[size];
	for(int i = 0; i < size; i++){
	    bois[i] = (int)(Math.random() * 100);
	}
	return bois;
    }
    
    //returns time taken to sort the array
    public static long timeTaken(int[] arr) {
	long startTime = System.nanoTime();
	MergeSort.sort(arr);
	long endTime = System.nanoTime();
	return endTime - startTime;
    }

    public static long average(int size, int numTimes) {
	long sum = 0;
	for (int i = 0; i < numTimes; i++) {
	    sum += timeTaken(generate(size));
	}
	return sum / numTimes;
    }
    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args ) 
    {
	System.out.println("Average of size 1, 100,000 times: " + average(1, 100000));
	System.out.println("Average of size 10, 100,000 times: " + average(10, 100000));
	System.out.println("Average of size 100, 100,000 times: " + average(100, 100000));
	System.out.println("Average of size 1000, 100,000 times: " + average(1000, 100000));
	
    }//end main

}//end class
