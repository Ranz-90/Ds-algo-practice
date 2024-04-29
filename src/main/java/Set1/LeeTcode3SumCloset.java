package Set1;

import java.util.Arrays;

public class LeeTcode3SumCloset {

	public static void main(String[] args) {
		
		
		/*
		 * Input: nums = [-1,2,1,-4], target = 1 Output: 2 Explanation: The sum that is
		 * closest to the target is 2. (-1 + 2 + 1 = 2).
		 */

		
		/*
		 * int[] nums = {-1,2,1,-4};
		 * 
		 * int target = 1;
		 */
		
		int nums[] = {-1,2,1,-4};
		
		int target = -100;
		
		//int closet = getClosetSum1(nums,target);
		
		int closet = threeSumClosest(nums,target);
		
		System.out.println(closet);
	}

	private static int getClosetSum1(int[] nums, int target) {
		
		Arrays.sort(nums);
		
		int closeSum = 0;
		
		int length = nums.length;
		
		int diff = Integer.MAX_VALUE;
		
//		/if(target < 0) target = (-1)*target;
		
		for(int i =0; i <length -2; i++ ) {
			
			int sum = target - nums[i];
			
			int low = i + 1;
			int high = length -1;
			
			while(low < high) {
				
				if(Math.abs (sum - (nums[low]+nums[high])) < Math.abs(diff)) {
					diff = sum - (nums[low]+nums[high]);
					closeSum = nums[i] + nums[low] + nums[high];
				}
				
				low++;
				high--;
			}
		}
		
		return closeSum;
	}


    public static int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int length = nums.length;
        
        int closeSum = nums[0] + nums[1] + nums[length-1];
        
        for(int i =0; i < length-2; i++){
            
            int low = i+1;
            int high = length-1;
            
            while(low < high){
                
                int temp = nums[i] + nums[low] + nums[high];
                
                if( temp > target) high--;
                else low++;
                
                if(Math.abs(closeSum - target) > Math.abs(temp - target)){
                    
                    closeSum = temp;
                }
            }
        }
        
        return closeSum;
        
    }
}
