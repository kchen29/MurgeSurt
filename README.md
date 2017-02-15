# Team MurgeSurt: Kenny Chen, Jasper Cheung, and Grace Cuenca
## Merge Sort Classification: O(nlogn)

### Our findings:

In order to gather empiracal data, we gathered ran our mergesort algorithm 1000 times, averaged the time results, and continuously made the array size bigger.


Merge sorting takes into account two functions: merge() and sort(). However, the essential steps of this process
are splitting the array until n arrays of length one are formed, joining subarrays, and sorting them. Dividing each array
will have a runtime of O(1) because the process simply finds the middle index of an array. After the array is iterated through,
there will be n number of arrays of length, 1. If we have an array of 16 elements, there will be 4 (log base 2 16) halvings, creating 4 levels.
On each of these levels, merge() has a runtime of O(n) because there are more merges to be made, but on a smaller scale. These
O(n) merges are conducted log base 2 n times, resulting in a runtime of n(log base 2 n), resulting in a final runtime of
O(nlogn).