package hackerrank;

public class StringProblem1 {

    public static void main(String[] args){

      //String[] input = {"hello", "world"};
        String[] input = {"geeksforgeeks", "geeks","geek","geezer"};
      String longestCommonString = "";

      String shortest = getShortestString(input);
      int index = 0;

      if (null != shortest && !shortest.isEmpty()){

          char[] chars = shortest.toCharArray();

          for(char c : chars){
              if(isPresentInAllWord(c,input,index)){
                  longestCommonString += Character.toString(c);
                  index++;

              }
              else{
                  continue;
              }
          }
      }

      if(longestCommonString.isEmpty() || longestCommonString.length() < 2){
          System.out.println("-1");
      }

      else{
          System.out.println(longestCommonString);
      }

    }

    private static boolean isPresentInAllWord(char l, String[] input, int index) {
        for(String str : input){
            if(str.charAt(index) != l){
                return false;
            }
        }
        return true;
    }

    private static String getShortestString(String[] input) {

        String str = "";
        int size = Integer.MAX_VALUE;
        for(String word: input){
            char[] wordinChars = word.toCharArray();
            if(wordinChars.length < size){
                size = wordinChars.length;
                str = word;
            }

        }
        return str;

    }
}
