import java.util.Arrays;

public class LongestCommmonPrefix {

	public static void main(String[] args) {
		/*
		 * Input: {"geeksforgeeks", "geeks", "geek", "geezer"} Output: "gee"
		 * 
		 * Input: {"apple", "ape", "april"} Output: "ap"
		 */
		
        String[] input = {"flower","flow","flight"};
        System.out.println( "The longest Common Prefix is : " +
                                   longestCommonPrefix(input));

	}

	private static String longestCommonPrefix(String[] input) {
		
		Arrays.sort(input);
		
		int minLength = Math.min(input[0].length(), input[input.length-1].length());
		
		int i =0;
		
		while( i < minLength && input[0].charAt(i)  == input[input.length-1].charAt(i)) i++;
		
		if( i == 0) return null;
		else return input[0].substring(0, i);
	}

}
