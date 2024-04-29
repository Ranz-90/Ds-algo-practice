package Day1;

import java.util.Arrays;

public class SingleNumberIILeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = {2,3,4,5,3,2,2,5,3,5};
		
		int output = singleNumber(input);
		
		System.out.println(output);

	}
	
    public static int singleNumber(int[] nums) {
        
        int length = nums.length;
        if( length == 1) return nums[0];
        int i =1;
        int result = 0;
        Arrays.sort(nums);
        
        while(i < nums.length-1){
            
            if( nums[i] != nums[i-1]) return nums[i-1];
            
            else if (nums[length-1] != nums[length -2]) return nums[length-1];
            
            else if(nums[i] == nums[i-1]){
            	result = nums[i-1];
            	 i = i+3;
            }
            }
        return result;
        }


}
