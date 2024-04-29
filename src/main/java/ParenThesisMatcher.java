import java.util.Stack;

public class ParenThesisMatcher {

	public static void main(String[] args) {
		
		String parenthesis = "[[{{}}]]";
		
		if(isValid(parenthesis)) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Not Valid");
		}

	}

	private static boolean isValid(String parenthesis) {

		char[] arr = parenthesis.toCharArray();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == '(' || arr[i] == '{' || arr[i] == '['){
				stack.push(arr[i]);
			}
			
			else {
				if(stack.isEmpty()){
					return false;
				}
				
				else {
					 char ch = stack.peek();
					 
					 if(arr[i] == ')' && ch != '(' || arr[i] == '}' && ch != '{' || arr[i] == ']' && ch != '[') {
						 return false;
					 }
					 else {
						 stack.pop();
					 }
				}
			}
		}
		
		if(stack.isEmpty()) return true;
		else return false;
	}

}
