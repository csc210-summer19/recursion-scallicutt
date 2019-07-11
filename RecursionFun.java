//Samantha Callicutt, CSC210, Summer 2019

/**
 * Complete the seven methods methods in this file using recursion, no loops. 
 * Also complete these three methods inside LinkedList<E>:
 *   get(int)
 *   removeAll(E)
 *   duplicateAll(E)
 *   
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 *   findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will
 * be using this same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Samantha Callicutt
 */
public class RecursionFun {

  // Complete recursive method combinations that returns from n choose k.
  // This method is described in 17_SimpleRecursion.pptx.
  public int combinations(int n, int k) {
    if(k == 1) {
    	return n;
    }
    if(n == k) {
    	return 1;
    }
    return combinations(n-1, k-1) + combinations(n-1, k);
  }

 
  // Complete recursive method intWithCommas that returns the argument as a String
  // with commas in the correct places.
  //
  // intWithCommas(999) returns "999"
  // intWithCommas(1234) returns "1,234"
  // intWithCommas(1007) returns "1,007"
  // intWithCommas(1023004567) returns "1,023,004,567"
  //
  // Precondition: n >= 0
  public String intWithCommas(int n) {
    return commaHelper(String.valueOf(n)); 
  }
  
  private String commaHelper(String str) {
	  if(str.length() <= 3) {
		  return str;  
	  }
	  return commaHelper(str.substring(0, str.length()-3)) + "," + commaHelper(str.substring(str.length()-3));	  	  
  }
  
  

  // Write recursive method reverseArray that reverses the array elements in a
  // filled array of ints. Use recursion; do not use a loop. The following
  // assertions must pass:
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // Precondition: x.length > 0
  public void reverseArray(int[] x) {
    // You need a private helper that needs additional arguments.
    // like x and x.length to keep track of array the indexes
    // with no loop. Here is an example with the private helper
    // immediately below.
    reverseArray(x, 0, x.length);
  }

  private void reverseArray(int[] x, int index, int len) {
    // TODO: Complete this method with a recursive algorithm. 
    // Do NOT use a loop.
	int temp;
	if(len == 1) {
		return;
	}
	int halfLen = len/2;
	if(index < halfLen) {
		temp = x[index]; 
		x[index] = x[len-1-index]; 
		x[len-1-index] = temp;
		reverseArray(x, index+1, len);
	}
  }

  // Write recursive method arrayRange that returns the maximum
  // integer minus the minimum integer in the filled array of 
  // integers, Use recursion; do not use a loop. 
  // Precondition: a.length > 0
  public int arrayRange(int[] a) {
	  int maxNum = arrayMax(a, 0);
	  int minNum = arrayMin(a, 0);
	  return maxNum - minNum;
  }
  
  private int arrayMax(int[] a, int index) {
	  if (index < a.length) {
		  return Math.max(a[index], arrayMax(a, index + 1));
	  }
	  else {
		return a[0];
	  }
	  
  }
  
  private int arrayMin(int[] a, int index) {
	  if (index < a.length) {
		  return Math.min(a[index], arrayMin(a, index + 1));
	  }
	  else {
		return a[0];
	  }
	  
  }

  // Return true if nums has all int elements in ascending order.
  // If not isSorted, return false.
  public boolean isSorted(int[] nums) {
    // Need to send down 0 to keep track of the index
	return sortedHelper(nums, 0); 
  }
  
  private boolean sortedHelper(int[] nums, int index) {
	  if (index < nums.length - 1) {
			if (nums[index] > nums[index + 1]) {
				return false;
			} 
			else {
				return sortedHelper(nums, index+1);
			}
	  }
	  return true;
  }

  // Complete method found to return true if search is found in strs.
  // If not found, return false. Use equals, not ==.
  public boolean found(String search, String[] strs) {
	  return foundHelper(search, strs, 0);
  }
  
  private boolean foundHelper(String search, String[] strs, int index) {
		if (index < strs.length) {
			if (strs[index].equals(search)) {
				return true;
			} 
			else {
				return foundHelper(search, strs, index+1);
			}
		} 
		else {
			return false;
		}
  }
}
