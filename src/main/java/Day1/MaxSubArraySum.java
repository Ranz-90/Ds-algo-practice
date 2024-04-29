
package Day1;
public class MaxSubArraySum {

	public static void main(String[] args) {
		
		/*
		 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has
		 * the largest sum = 6.
		 */
		
		/*
		 * Input: nums = [5,4,-1,7,8] Output: 23
		 */
		
		// -2,1    1,2  -1,-2
		
		int[] nums = {1,2};
		
		int output = maxSubArray(nums);
		
		System.out.println(output);

	}
	
    public static int maxSubArray(int[] nums) {

    	int sum = 0;
    	int max = nums[0]; 
    	
    	for(int i =0; i < nums.length; i++) {
    		sum = sum+nums[i];
    		max = Math.max(max, sum);
    		if(sum < 0) sum =0;
    	}
    	
    	return max;
        
    }

}
