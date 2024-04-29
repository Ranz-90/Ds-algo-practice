package array;

public class LiftingMaxWeightsUsingDP {
    public static void main(String[] args){
        int[] weights = {1,3,5};
        int maxCapacity = 7;

        int max = getMaxWeight(weights,maxCapacity);
        System.out.println(max);
    }

    private static int getMaxWeight(int[] weights, int maxCapacity) {

        int length = weights.length;
        int[][] dp = new int[length+1][maxCapacity+1];

        for(int i =1; i <=length; i++){
            for(int j=1;j<=maxCapacity;j++){
                if(weights[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]] + weights[i-1]);
                }
            }
        }

        return dp[length][maxCapacity];
    }


}
