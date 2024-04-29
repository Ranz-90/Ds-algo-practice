package Set1;

public class ClimbingStairs {

	public static void main(String[] args) {
		
		int n = 3;
		
		int output = climbStairs(n);
		
		
		
		System.out.println(output);

	}
	
    public static int climbStairs(int n) {
         

    	int[] dp = new int[n+1];
    	
    	for(int i =0; i <= n; i++) {
    		dp[i] = -1;
    	}
    	
    	return climbStairsWays(n,dp);
    }

	private static int climbStairsWays(int n, int[] dp) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n ==2) return 2;
		
		if(dp[n] != -1) return dp[n];
		
		return dp[n] = climbStairsWays(n-1,dp) + climbStairsWays(n-2,dp);
	}

}
