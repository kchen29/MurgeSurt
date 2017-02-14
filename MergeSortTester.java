/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
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
	long startTime = System.currentTimeMillis();
	MergeSort.sort(arr);
	long endTime = System.currentTimeMillis();
	return endTime - startTime;
    }
    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args ) 
    {
	int[] arr7 = {9,42,17,63,0,9,512,23,9, 1, 86, 13, 8, 4, 12};
	System.out.println("Time taken: " + timeTaken(arr7));
	for(int i = 0; i < 10; i++){
	    MergeSort.printArray(generate(10));
	}
    }//end main

}//end class
