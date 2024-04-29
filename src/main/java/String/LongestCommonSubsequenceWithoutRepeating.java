package String;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequenceWithoutRepeating {

    public static void main(String[] args){
        String input = "abcabcbb";

        int output = getLongestCommonSubSequence(input, input.length());

        System.out.println(output);
    }
    private static int getLongestCommonSubSequence(String input, int length) {
        int start =0;
        int end =0;
        int maxLen =0;
        Map<Character, Integer> map = new HashMap<>();

      while(end < length){
          if(map.containsKey(input.charAt(end))){
              start = Math.max(start,map.get(input.charAt(end)) +1 );
          }
          maxLen = Math.max(maxLen, end-start+1);
          map.put(input.charAt(end), end);
          end++;
      }
      return maxLen;
    }
}
