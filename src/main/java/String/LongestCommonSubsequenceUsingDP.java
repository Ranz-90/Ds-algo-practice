package String;

public class LongestCommonSubsequenceUsingDP {

    public static void main(String[] args){

        String S1 ="AGGTAB";
        String S2 = "GXTXAYB";
        int output = getLongestCommonSubsequence(S1,S2);
        System.out.println(output);
    }

    private static int getLongestCommonSubsequence(String S1, String S2) {

        int len1 = S1.length();
        int len2 = S2.length();
        int[][] dp = new int[len1][len2];

        for(int i =0; i <len1; i++){
            for(int j=0; j < len2; j++){
                dp[i][j] = -1;
            }
        }

        return getLongestSubLenUsingDP(0,0,len1, len2,S1, S2,dp);
    }

    private static int getLongestSubLenUsingDP(int i, int j, int len1,int len2, String S1,String S2, int[][] dp) {


        if(i >=len1 || j>=len2) return 0;
        if(dp[i][j] != -1) return dp[i][j];

            if(S1.charAt(i) == S2.charAt(j)){
                return dp[i][j] = 1 + getLongestSubLenUsingDP(i+1, j+1,len1, len2,S1, S2,dp);
            }
            else{
                int left = getLongestSubLenUsingDP(i+1, j,len1,len2,S1,S2,dp);
                int right = getLongestSubLenUsingDP(i, j+1,len1,len2,S1,S2,dp);

                return dp[i][j] = Math.max(left, right);
            }
        }
}
