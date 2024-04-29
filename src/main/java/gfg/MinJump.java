package gfg;

public class MinJump {

	public static void main(String[] args) {
		int[] nums = {9, 10 ,1, 2, 3 ,4 ,8 ,0, 0, 0 ,0, 0, 0, 0, 1};
		
		//int[] nums = {2,1,0,3};
		
		int min = minJumps(nums);
		
		System.out.println(min);

	}
	
    static int minJumps(int[] arr){
        // your code here
        if(arr.length == 1 && arr[0] == 0) return 0;
        if(arr[0] == 0) return -1;
        
        int minJump = 0;
        int cutStep = 0;
        int dest =0;
        int length = arr.length-1; 
            
            for(int i =0; i < length; i++){
            	if(arr[i] != 0) {
                    dest = Math.max(dest, i+arr[i]);
                    
                    if(dest == length) return 1+minJump;
                    
                    
                    if(cutStep == i){
                        cutStep = dest;
                        minJump++;
                    }
            	}
            	else if(dest < length && arr[dest] == 0){
            		return -1;
            	}

            }
        return minJump;
    }

}
