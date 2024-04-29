public class LengthOfLastWordLeetCode {

	public static void main(String[] args) {
	
		/*
		 * Input: s = "Hello World" Output: 5 Explanation: The last word is "World" with
		 * length 5. Example 2:
		 * 
		 * Input: s = "   fly me   to   the moon  " Output: 4 Explanation: The last word
		 * is "moon" with length 4. Example 3:
		 * 
		 * Input: s = "luffy is still joyboy" Output: 6 Explanation: The last word is
		 * "joyboy" with length 6.
		 */
		
		String s ="   fly me   to   the moon  ";
		
		//int lastWordLength = lengthOfLastWord(s);
		
		int lastWordLength = lengthOfLastWordOptimal(s);
		
		System.out.println(lastWordLength);
	}
	
    private static int lengthOfLastWordOptimal(String s) {
		
    	int i = s.length()-1;
    	String lastWord = "";
    		
    		while(i > 0 && !Character.isLetter(s.charAt(i))) {
    			i--;
    		}
        		int j = i;
        		while(j > 0 && Character.isLetter(s.charAt(j))) {
        			j--;
    		}
        	lastWord = s.substring(j+1,i+1);
        	System.out.println(lastWord);
			return lastWord.length();
	}

	public static int lengthOfLastWord(String s) {
    	
    	
    	int length = s.length();
    	String word ="";
    	
    	int i =0;
    	
    	while( i < length) {
    		
    		while(i < length && !Character.isLetter(s.charAt(i))) {
    			i++;
    		}

    		if( i >= length) break;
    		int j = i+1;
    		while(j < length && Character.isLetter(s.charAt(j))) {
    			j++;
    		}
    		 word = s.substring(i, j);
    		i = j+1;
    	}
    	
    	System.out.println(word);
    	return word.length();
        
    }

}
