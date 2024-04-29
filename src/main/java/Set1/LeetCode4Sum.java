package Set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode4Sum {

	public static void main(String[] args) {
		
		/*
		 * Input: nums = [1,0,-1,0,-2,2], target = 0 Output:
		 * [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
		 * 
		 * Input: nums = [2,2,2,2,2], target = 8 Output: [[2,2,2,2]]
		 */
		
		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		
		List<List<Integer>> output = fourSum(nums, target);
		
		if(!output.isEmpty()) {
			for(List<Integer> l : output) {
				System.out.println(l);
			}
		}
		

	}
	
		public static List<List<Integer>> fourSum(int[] nums, int target) {
			
			List<List<Integer>> quadList = new ArrayList<>();
			
			Arrays.sort(nums);
			
			int length = nums.length;
			
			for(int i=0; i < length;i++) {
				for(int j=i+1; j < length;j++) {
					
					int target2 = target - (nums[i]+nums[j]);
					
					int low = j+1;
					int high = length-1;
					
					while(low < high) {
						
						if (nums[low] + nums[high] < target2) low++;
						else if(nums[low] + nums[high] > target2) high--;
						else {
							
							List<Integer> quad = new ArrayList<>();
							
							quad.add(nums[i]);
							quad.add(nums[j]);
							quad.add(nums[low]);
							quad.add(nums[high]);
							quadList.add(quad);
							while(low < high && nums[low] == quad.get(2))low++;
							while(low < high && nums[high] == quad.get(3))high--;
							
						}
					}
					
					while(j+1 < length && nums[j+1] == nums[j]) j++;
				}
				
				while(i+1 < length && nums[i+1] == nums[i])i++;
			}
			
			return quadList;
        
    }

}
