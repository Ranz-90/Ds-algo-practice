package Set1;

public class RemoveElementLeetCode {

	public static void main(String[] args) {
		
		/*
		 * Input: nums = [3,2,2,3], val = 3 Output: 2, nums = [2,2,_,_]
		 * 
		 * Input: nums = [0,1,2,2,3,0,4,2], val = 2 Output: 5, nums = [0,1,4,0,3,_,_,_]
		 */
		
		int[] nums = {0,1,2,2,3,0,4,2};
		int val = 2;
		
		int output = removeElement(nums,val);
		
		System.out.println(output);
	}
	
    public static int removeElement(int[] nums, int val) {
    	
    	int i =0;
    	int j =0;
    	int length = nums.length;
    	while(j < length ) {
    		if(nums[j] != val) {
    			i++;
    		}
    		j++;
    	}
    	
		return i;
        
    }

}
