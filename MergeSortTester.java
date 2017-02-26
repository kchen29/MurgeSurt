//Team MurgeSurt (Kenny Chen, Jasper Cheung, and Grace Cuenca)
//APCS2 pd1
//HW07 -- What Does the Data Say
//2017-02-14

/*======================================
  class MergeSortTester

  ALGORITHM:
  Calculates the time it takes for mergesort to run on arrays of different sizes. Using nano seconds to measure sorts. 
  Original MergeSort Algorithm works by invoking recursion to split a given array into smaller arrays until each array is of size one. Once that is accomplished, each array is merged back together with each successive elemnt being added being sorted along the way.

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(nlog(n))

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
  n=500 000 time: 88 774 648 nanoseconds
  n=1 000 000 time: 216 914 083 nanoseconds
  ...
  n=<huge>  time: huge*(log(huge)) nanoseconds


  ANALYSIS:
  Merge sorting takes into account two functions: merge() and sort(). However, the essential steps of this process
  are splitting the array until n arrays of length one are formed, joining subarrays, and sorting them. Dividing each array
  will have a runtime of O(1) because the process simply finds the middle index of an array. After the array is iterated through,
  there will be n number of arrays of length, 1. If we have an array of 16 elements, there will be 4 (log base 2 16) halvings, creating 4 levels.
  On each of these levels, merge() has a runtime of O(n) because there are more merges to be made, but on a smaller scale. These
  O(n) merges are conducted log base 2 n times, resulting in a runtime of n(log base 2 n), resulting in a final runtime of
  O(nlogn).
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
     * the average function takes in the size of the array and the batch size.
     * First we run the average 100000 times to avoid outliers in runtime.
     * Timetaken calcuates the time it takes for a sort to occur. 
     * Average out the timetaken for each sort by batch size
     ******************************/
    public static void main( String[] args ) 
    {
        average(100, 100000); //warm up
	/*System.out.println("Average of size 1, with 2 000 times: " + average(1, 2000));
	System.out.println("Average of size 10, with 2 000 times: " + average(10, 1000));
	System.out.println("Average of size 100, with 2 000 times: " + average(100, 1000));
	System.out.println("Average of size 1 000, with 2 000 times: " + average(1000, 1000));
        System.out.println("Average of size 5 000, with 2 000 times: " + average(5000, 1000));
        System.out.println("Average of size 10 000, with 2 000 times: " + average(10000, 1000));
        System.out.println("Average of size 50 000, with 2 000 times: " + average(50000, 1000));
        System.out.println("Average of size 100 000, with 2 000 times: " + average(100000, 1000));*/
	System.out.println("Average of size 500 000, with 2 000 times: " + average(500000, 1000));
	System.out.println("Average of size 1 000 000, with 2 000 times: " + average(1000000, 1000));
	System.out.println("Average of size 5 000 000, with 2 000 times: " + average(5000000, 1000));
	System.out.println("Average of size 10 000 000, with 2 000 times: " + average(10000000, 1000));
        System.out.println("Average of size 50 000 000, with 2 000 times: " + average(50000000, 1000));
        System.out.println("Average of size 100 000 000, with 2 000 times: " + average(100000000, 1000));
	     
    }//end main

}//end class

