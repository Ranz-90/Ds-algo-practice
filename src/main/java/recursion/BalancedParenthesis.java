package recursion;

import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args){

        String input = "(({}))";
        Stack<Character> st = new Stack<>();
        char[] charArray = input.toCharArray();

        for(int i =0; i<charArray.length;i++){
            if(charArray[i] == '(' || charArray[i] =='{' || charArray[i] =='['){
                st.push(charArray[i]);
            }
            else{
                if(st.empty()){
                    System.out.println("Not Balanced");
                }

                else {
                    char c = st.peek();

                    if(charArray[i] == ')' && c != '(' || charArray[i] == '}' && c != '{' || charArray[i] == ']' && c != '['){
                        System.out.println("Not Balanced");
                    }
                    else{
                        st.pop();
                    }
                }
            }
        }
        if(st.empty()){
            System.out.println("Balanced");
        }
        else{
            System.out.println("Not Balanced");
        }
    }
}
