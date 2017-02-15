/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: 2 000 times
  n=1       time: 27         nanoseconds
  n=10      time: 664        nanoseconds
  n=100     time: 9 915      nanoseconds
  n=1 000   time: 131 865    nanoseconds
  n=5 000   time: 681 728    nanoseconds
  n=10 000  time: 1 392 734  nanoseconds
  n=50 000  time: 7 541 120  nanoseconds
  n=100 000 time: 15 373 874 nanoseconds

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

    //returns the average time taken for sorting numTimes arrays of length size
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
        average(100, 100000); //warm up
	System.out.println("Average of size 1, with 2 000 times: " + average(1, 2000));
	System.out.println("Average of size 10, with 2 000 times: " + average(10, 2000));
	System.out.println("Average of size 100, with 2 000 times: " + average(100, 2000));
	System.out.println("Average of size 1 000, with 2 000 times: " + average(1000, 2000));
        System.out.println("Average of size 5 000, with 2 000 times: " + average(5000, 2000));
        System.out.println("Average of size 10 000, with 2 000 times: " + average(10000, 2000));
        System.out.println("Average of size 50 000, with 2 000 times: " + average(50000, 2000));
        System.out.println("Average of size 100 000, with 2 000 times: " + average(100000, 2000));
    }//end main

}//end class
