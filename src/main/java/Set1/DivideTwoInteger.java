package Set1;

public class DivideTwoInteger {

	public static void main(String[] args) {
	
		int output = divide(7,3);
		
		System.out.println(output);

	}
	
    public static int divide(int dividend, int divisor) {
        
    	if(dividend == 1<<31 || dividend == -1 ) return Integer.MAX_VALUE;
    	
    	boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
    	int result = 0;
    	dividend = Math.abs(dividend);
    	divisor = Math.abs(divisor);
    	while(dividend - divisor >= 0) {
    		
    		int count = 0;
    		
    		while(dividend - (divisor <<1 << count) >= 0 ) {
    			count++;
    		}
    		
    		result += 1 << count;
    		dividend -= divisor << count;
    	}
		return result;
    }
}
