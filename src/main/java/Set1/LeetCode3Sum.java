package Set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode3Sum {

	public static void main(String[] args) {
		
		
		/*
		 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
		 */
		
		int[] nums = {-1,0,1,2,-1,-4};
		
		List<List<Integer>> sumList = threeSum(nums);
		
		if(null != sumList && !sumList.isEmpty()) {
			
			for(List<Integer> list : sumList) {
				System.out.println(list);
			}
		}
	}
	
    public static List<List<Integer>> threeSum(int[] nums) {
        
  
    	List<List<Integer>> output = new ArrayList<>();
    	
    	//1st step Sort the array:
    	
    	Arrays.sort(nums);
    	
    	//iterate till 3rd last index 
    	
    	for(int i =0; i < nums.length-2; i++) {
    		
    		
    		//to make sure duplicates are not taking
    		
    		if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
    			
    			int sum = 0 - nums[i];
    			int low =i+1;
    			int high = nums.length -1;
    			
    			
    			//fixing nums[i]by nums - sum[i] and started two pointer now ny low high
    			
    			while(low < high) {
    				
    				if(nums[low] + nums[high] == sum) {
    					
    					output.add(Arrays.asList(nums[i], nums[low], nums[high]));
    					
    					//the moment we found triplets we have to skip same elememts to get unique.
    					
    				while(low < high && nums[low] == nums[low+1]) low++;
    				while(low < high && nums[high] == nums[high-1]) high--;
    				
    				low++;
    				high--;
    				}
    				
    				else if(nums[low] + nums[high] < sum) low ++;
    				else high--;
    			}
    				
    		}
    	}
    	
		return output;
        
    }

}
