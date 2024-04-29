public class SearchInsertPoistion {

	public static void main(String[] args) {
		
		/*
		 * Example 1:
		 * 
		 * Input: nums = [1,3,5,6], target = 5 Output: 2 Example 2:
		 * 
		 * Input: nums = [1,3,5,6], target = 2 Output: 1 Example 3:
		 * 
		 * Input: nums = [1,3,5,6], target = 7 Output: 4
		 */
		
		int[] nums = {1,3,5,6};
		
		int target = 2;
		
		int output = searchInsert(nums,target);
		
		System.out.println(output);

	}
	
	 public static int searchInsert(int[] nums, int target) {
	        
	        int length = nums.length;
	        
	        int low = 0;
	        int high = length-1;
	        
	        while( low <= high){
	        	

	            int mid = (low + high)/2;
	            
	            if(nums[mid] == target){
	                return mid;
	            }
	            
	            else if (nums[mid] < target){
	                low = mid+1;
	            }
	            else{
	                high = mid-1;
	            }
	        }
	        return high+1;
	    }

}
