/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  If the array is of list 1, return it (it is sorted)
  Split the array into two arrays, and run this algorithm on each of them.
  When the two arrays are sorted, merge the arrays together while keeping
  their sorted state.
  The array is sorted once the arrays are merged.
  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	//look at the top of the two arrays and keep adding the element
	//that is lower to the new array until one array is gone
	int[] merged = new int[a.length + b.length];
	int i = 0;
	int j = 0;
	while (i < a.length && j < b.length) {
	    if (a[i] < b[j]) {
		merged[i + j] = a[i];
		i++;
	    } else {
		merged[i + j] = b[j];
		j++;
	    }
	}

	//add the rest of the array to the new array
	if (i < a.length) {
	    append(merged, a, i + j, i);
	} else {
	    append(merged, b, i + j, j);
	}
        return merged;
    }//end merge()

    //appends array b to array a (assumes array a has enough space to hold b)
    //starting from index i in a and index j in b
    private static void append( int[] a, int[] b, int i, int j)
    {
	while(j < b.length) {
	    a[i] = b[j];
	    i++;
	    j++;
	}
    }
    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
        if (arr.length <= 1)
	    return arr;

	int[] first = new int[arr.length / 2];
	for (int i = 0; i < arr.length / 2; i++)
	    first[i] = arr[i];

	int[] second = new int[arr.length - arr.length / 2];
	for(int i = arr.length / 2; i < arr.length; i++)
	    second[i - arr.length / 2] = arr[i];

	return merge(sort(first), sort(second));
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );


	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort

