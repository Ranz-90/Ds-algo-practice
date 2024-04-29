package Set1;

import java.util.Stack;

public class SortStackUsingRecusrion {

	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
        
        sortStack(s);
        
        while(!s.isEmpty()) {
        	System.out.println(s.pop());
        }

	}

	private static void sortStack(Stack<Integer> s) {
		
		if(!s.isEmpty()) {
			
			int pop = s.pop();
			
			sortStack(s);
			
			sortAndInsert(s,pop);
		}
		
	}

	private static void sortAndInsert(Stack<Integer> stack, int val) {
		
		if(stack.isEmpty()|| stack.peek() > val) {
			stack.push(val);
			
			return;
		}
		
		int temp = stack.pop();
		
		sortAndInsert(stack,val);
		
		stack.push(temp);
	}

}
