import java.util.Stack;

public class ValidParenthesisPractice2 {

    public static void main(String[] args){

        String input = "(({}))";

       checkValidOrNot(input);
    }

    private static void checkValidOrNot(String input) {

        Stack<Character> stack = new Stack<>();

        char[] charArray = input.toCharArray();

        for(int i =0; i <charArray.length; i++){

            if(charArray[i] == '(' || charArray[i] == '{' || charArray[i] == '['){
                stack.push(charArray[i]);
            }

            else{

                if(stack.isEmpty()) System.out.println("Not Balanced");

                else{

                    char c= stack.peek();

                    if(charArray[i] == ')' && c != '(' ||charArray[i] == '}' && c != '{' || charArray[i] == ']' && c != '[' ){
                        System.out.println("Not Balanced");
                    }
                    else{
                        stack.pop();
                    }
                }
            }

        }

        if(stack.isEmpty())System.out.println(" Balanced");
        else System.out.println("Not Balanced");
    }
}
