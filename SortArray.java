
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortArray {
	
	private static int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
        20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
        13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11,-1};  

	public static void main(String[] args) {
		
		int [] array1 = SortArray.removeDuplicatesUsingArrayList(randomIntegers);
		for(int i : array1) {
			System.out.print(i+" ");
		}
		System.out.println();
		int [] array2 = SortArray.removeDuplicatesUsingSet(randomIntegers);
		for(int i : array2) {
			System.out.print(i+" ");
		}
		System.out.println();
		int [] array3 = SortArray.removeDuplicates(randomIntegers);
		for(int i : array3) {
			System.out.print(i+" ");
		}
	}
	/*
	 *  This method will remove the duplicate and negative numbers from the given array using ArrayList
	 */
	public static int[] removeDuplicatesUsingArrayList(int [] randomArray) {
		List<Integer> list = new ArrayList<Integer>();                   // Create an integer array list
		int length = randomArray.length;
		for(int i=0;i<length;i++) {
			if(!list.contains(randomArray[i]) && (randomArray[i]>=0)) {  // Check whether the list contains the value and if it is non negative 
				list.add(randomArray[i]);	                             // Add the value to the list
			}
		}
		System.out.println("list size - "+list.size());
		int[] uniqueArray = new int[list.size()];                        // Create a new array for the list size
	    int i = 0;
	    for (int j : list) {
	    	uniqueArray[i] = j;                                          // Add values to the array from list
	        i++;
	    }
		return uniqueArray;
	}
	/*
	 *  This method will remove the duplicate and negative numbers from the given array using TreeSet which stores values in natural order
	 */
	public static int[] removeDuplicatesUsingSet(int [] randomArray) {
		int length = randomArray.length;
		Set<Integer> set = new TreeSet<Integer>();                      // Create an integer set
		   for(int i=0;i<length;++i){
			   if((randomArray[i]>=0)) {                                // Check whether the value is non negative
				   set.add(randomArray[i]);                             // Add the value to the set
			   }
		}
		int[] uniqueArray = new int[set.size()];                        // Create a new array for the set size
		int i = 0;
		for (int j : set) {
			uniqueArray[i] = j;                                         // Add values to the array from set
		    i++;
		}
		return uniqueArray;
	}
	/*
	 *  This method will remove the negative numbers from the given array
	 */
	public static int[] removeNegativeNumbers(int [] randomIntegers){
		int length = randomIntegers.length;
		int uniqueArrayLength=length;
	    for (int i = 0; i < length; i++) {    // Calculate the length of the array without negative numbers
	    	if(randomIntegers[i]<=0) {
	    		uniqueArrayLength--;          // if negative number found, decrease length 
	    	}
	    }
	    int count=0;
	    int [] uniqueArray = new int [uniqueArrayLength]; // Create an int array for the calculated length and add non negative numbers to the array
	    for (int i = 0; i < length; i++) {
	    	if(randomIntegers[i]>=0) {
	    		uniqueArray[count++] = randomIntegers[i];   
	    	}
	    }
		return uniqueArray;
	}
	/*
	 *  This method will remove the duplicate values from the given array
	 */
	public static int[] removeDuplicates(int [] randomIntegers){
		int [] intArray = removeNegativeNumbers(randomIntegers); // Remove negative integers 
		int length = intArray.length;
		int newLength = length;
		for (int i = 1; i < length; i++) {            // Calculate the length of the array without duplicate values
	        for (int j = 0; j < i; j++) {
	        	if (intArray[i] == intArray[j]) {        // if duplicate found, decrease length 
	        		newLength--;
		            break;
		        }
	        }
	    }
		System.out.println("new length - "+newLength);
	    int[] newArray = new int[newLength];             // Create an int array for the calculated length and add non negative numbers to the array
	    newArray[0] = intArray[0];                       // Add 1st element to new array
	    int inx = 1;                                     
	    boolean isDuplicate;

	    for (int i = 1; i < intArray.length; i++) {
	        isDuplicate = false;
	        for (int j = 0; j < i; j++) {
	            if (intArray[i] == intArray[j])  {        // if duplicate found, change boolean variable and break
	            	isDuplicate = true;
	                break;
	            }
	        }
	        if (!isDuplicate) {                           // if it's not duplicate then put it into new array
	            newArray[inx] = intArray[i];
	            inx++;
	        }
	    }
	    return sortArray(newArray);                       // Sort the array
	}
	/*
	 *  This method will sort the given array
	 */
	public static int[] sortArray(int[] newArray){
        int length = newArray.length;
        int temp;
        for (int i = 1; i < length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(newArray[j] < newArray[j-1]){
                    temp = newArray[j];
                    newArray[j] = newArray[j-1];
                    newArray[j-1] = temp;
                }
            }
        }
        return newArray;
    }
	
}
