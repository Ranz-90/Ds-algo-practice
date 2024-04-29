package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

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
        List<String> output = new ArrayList<>();
        findCombination(0,0,input,output,"");
        return output;
    }

    private static void findCombination(int open, int close,int input, List<String> output, String str) {

        //Base / exit condition
        if(str.length() == 2*input){
            output.add(str);
            return;
        }

        //choice1
        if(open < input) {
            findCombination(open + 1, close, input, output, str + "(");
        }
        //choice 2
        if(close < open) {
            findCombination(open, close + 1, input, output, str + ")");
        }

    }
}
