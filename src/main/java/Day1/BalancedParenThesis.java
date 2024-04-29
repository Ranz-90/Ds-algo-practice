package Day1;

import java.util.Stack;

public class BalancedParenThesis {

	public static void main(String[] args) {
		
		String input = "[({})]";
		
		boolean flag = isValid(input);
		
		System.out.println(flag);

	}

	private static boolean isValid(String input) {
		
		Stack<Character> stack = new Stack<>();
		
		char[] charArray = input.toCharArray();
		
		for(int i =0; i < charArray.length; i++) {
			
			if(charArray[i] == '[' || charArray[i] == '{' || charArray[i] == '(') {
				
				stack.push(charArray[i]);
				
			}
			
			else {
				
				if(stack.isEmpty()) {
					return false;
				}
				else {
					
					char ch = stack.peek();
					
					if(charArray[i] == ')' && ch != '(' || charArray[i] == '}' && ch != '{' || charArray[i] == ']' && ch != '[') {
						return false;
					}
					else {
						stack.pop();
					}
				}
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

}
