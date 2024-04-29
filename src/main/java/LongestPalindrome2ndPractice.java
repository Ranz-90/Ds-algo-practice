public class LongestPalindrome2ndPractice {

    public static void main(String[] args){

        String str = "forgeeksskeegfor";

        String logestPalindrome = getLongestpalindrome(str);

        System.out.println(logestPalindrome);
    }

    private static String getLongestpalindrome(String str) {

        if(str.isEmpty()) return str;

        int start =0;
        int end = 0;
        int maxLen =0;

        for(int i =0; i <str.length(); i++){
            int odd = expand(str, i,i);
            int even = expand(str, i, i+1);

            maxLen = Math.max(odd,even);

            if(maxLen > end-start){
                start = i - (maxLen-1)/2;
                end = i + maxLen/2;
            }
        }

        return str.substring(start+1, end);
    }

    private static int expand(String str, int left, int right) {

        while( 0<= left && right < str.length()&& str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }

        return right-left+1;
    }


}
