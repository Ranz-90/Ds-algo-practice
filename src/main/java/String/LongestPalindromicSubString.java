package String;

public class LongestPalindromicSubString {

    public static void main(String[] args){
        String input = "forgeeksskeegfor";

        String output = getLongestPalindrome(input, input.length());

        System.out.println(output);
    }

    private static String getLongestPalindrome(String input, int length) {
        if(input.isEmpty()) return input;
        int start =0;
        int end =0;

        for(int i =0; i <length; i++){

            int odd = expand(input,i,i);
            int even = expand(input, i, i+1);

            int maxLen = Math.max(odd,even);

            if(maxLen > end - start){
                 start = i - (maxLen-1)/2;
                 end = i + maxLen/2;
            }
        }

        return input.substring(start+1, end);
    }

    private static int expand(String str, int left, int right) {

        while(0 <= left && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        return right -left +1;
    }
}
