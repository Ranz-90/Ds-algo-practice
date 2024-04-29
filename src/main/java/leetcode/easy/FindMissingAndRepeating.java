package leetcode.easy;

import java.util.Arrays;

public class FindMissingAndRepeating {

	public static void main(String[] args) {
		int[] nums = {2,2};
		int length = nums.length;
		int[] output = findTwoElement(nums,length);
		
		System.out.println("Missing" +output[1]);
		System.out.println("Repeating" +output[0]);

	}
	
    static int[] findTwoElement(int arr[], int n) {
        // code here
        
        int[] output = new int[2];
        int missing = 0;
        int repeating = 0;
        


       Arrays.sort(arr);
       
       for(int i =0; i <n; i++){

            if(i > 0 && arr[i] == arr[i-1]){
               repeating = arr[i];
           }
           else if(arr[i] != i+1){
               missing = i+1;
           }
       }
       output[0] = repeating;
       output[1] = missing;
        return output;
    }

}
