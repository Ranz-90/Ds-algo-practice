import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesisPractice2 {

    public static void main(String[] args){
        int input = 3;
        List<String> finalList = generateParenthesis(input);
        if(!finalList.isEmpty()){
            for(String str : finalList){
                System.out.println(str);
            }
        }
    }

    private static List<String> generateParenthesis(int input) {

        List<String> validParenthesis = new ArrayList<>();

        generateCombination(0,0,input,validParenthesis, "");

        return validParenthesis;
    }

    private static void generateCombination(int open, int close, int n, List<String> validParenthesis, String s) {

        if(s.length() == 2*n){
            validParenthesis.add(s);
            return;
        }

        //choice1:

        if(open < n)generateCombination(open+1,close,n,validParenthesis, s+"(");
        if(close< open)generateCombination(open,close+1,n,validParenthesis, s+")");
    }
}
