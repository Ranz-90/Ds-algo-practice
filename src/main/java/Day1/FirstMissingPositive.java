package Day1;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public int firstMissingPositive(int[] nums) {
        
        int length = nums.length;
        for(int i =0; i < length; i++){
            
            while(0<= nums[i] && nums[i] < length && nums[i] != nums[nums[i]-1]){
                swap(nums,nums[i], nums[nums[i]-1]);
            }
        }
       
        
        for(int i=0; i < nums.length; i++){
            if(nums[i] != i+1) return i+1;
        }
        
        return length +1;
        
    }

private void swap(int[] nums, int i, int j) {
	// TODO Auto-generated method stub
	
}
}
