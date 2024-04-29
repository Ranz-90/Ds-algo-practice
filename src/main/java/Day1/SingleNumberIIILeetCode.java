package Day1;

public class SingleNumberIIILeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int[] singleNumber(int[] nums) {
        
        int[] result = new int[2];
        int xy =0;
        int x =0;
        int y= 0;
        for(int num: nums) xy = xy^num;
        int rightMostBit = xy & -xy;
        
        for(int val: nums){
            if((rightMostBit&val) == 0){
                x = x^val;
            }
            else{
                y = y^val;
            }
        }
        result[0] = x;
        result[1] = y;
        return result;
        
    }

}
