public class LongestCommonSubsequenceDpPractice2 {


    public static void main(String[] args){

        String S1 ="AGGTAB";
        String S2 = "GXTXAYB";
        int output = getLongestCommonSubsequence(S1,S2);
        System.out.println(output);
    }

    private static int getLongestCommonSubsequence(String s1, String s2) {

        int[][] dp = new int[s1.length()][s2.length()];

        for(int i=0; i <s1.length(); i++){
            for(int j=0; j <s2.length(); j++){
                dp[i][j] = -1;
            }
        }

        return getLongestSub(0,0,s1.length(),s2.length(),dp,s1,s2);
    }

    private static int getLongestSub(int i, int j, int len1, int len2, int[][] dp, String s1, String s2) {

        if(i >= len1 || j >= len2) return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + getLongestSub(i+1, j+1,len1, len2,dp,s1,s2);
        }
        else{
            int left = getLongestSub(i+1, j,len1, len2,dp,s1,s2);
            int right = getLongestSub(i, j+1,len1, len2,dp,s1,s2);

            return dp[i][j] = Math.max(left,right);
        }
    }


}
