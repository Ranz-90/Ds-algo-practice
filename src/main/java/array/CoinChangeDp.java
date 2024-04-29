package array;

public class CoinChangeDp {

    public static void main(String[] args){

        int[] input = {7,2,6,5};
        int sum = 16;
        int len = input.length;


        int[] dp = new int[sum+1];
        dp[0] =1;

        for(int i =0; i < len; i++){
            for(int j = input[i]; j <=sum ; j++){
              dp[j] = dp[j] + dp[j - input[i]];
            }
        }

        System.out.println(dp[sum]);
    }
}
