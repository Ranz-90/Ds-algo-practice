package Day1;

import java.util.HashMap;
import java.util.Map;

public class TwoSumLeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,2,-3,6};
		
		int target = 0;
		
		//int[] result = getTwoSum(nums, target);
		
		int[] result = twoSum(nums,target);
		
		System.out.println(result[0] );
		System.out.println(result[1] );
	}

	private static int[] getTwoSumBruteForce(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i =0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for(int i =0; i < nums.length; i++) {


		}
		return result;
	}

	private static int[] getTwoSum(int[] nums, int target) {
		
        int[] result = new int[2];
        
        int i =0;
        int length = nums.length;
        int j = nums.length-1;
        
        while(i <length && j >=0){
            if(Math.abs(nums[i]+nums[j]) == Math.abs(target))
            {
                result[0] = i;
                result[1] = j;
                break;
            }
            else if(Math.abs(nums[i]+nums[j]) < Math.abs(target)){
                i++;
            }
            else{
              j--;  
            }
        }
        
        return result;
	}
	
    public static int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i =0; i < length; i++){
            map.put(nums[i],i);
        }
        
        for(int i =0; i < length; i++){
			int reminder = target - nums[i];
			if(map.get(reminder)!= null) {
				if(i != map.get(reminder)) {
					result[0] = i;
					result[1] = map.get(reminder);
					break;
				}
			}
        }
        
        return result;
        
    }

}
