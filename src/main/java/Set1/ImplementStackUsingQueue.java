package Set1;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
	
	Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		
		ImplementStackUsingQueue s = new ImplementStackUsingQueue();
	        s.push(10);
	        s.push(20);
	        System.out.println("Top element :" + s.top());
	        s.pop();
	        s.push(30);
	        s.pop();
	        System.out.println("Top element :" + s.top());
	}

	private int top() {
		
		if(queue.isEmpty()) {
			System.out.println("Queue is emmpty");
			return 0;
		}
		else {
			return queue.peek();
		}
	}

	private int pop() {
		
		if(queue.isEmpty()) {
			System.out.println("Queue is emmpty");
			return 0;
		}
		else {
			return queue.poll();
		}
			
	}

	private void push(int val) {
		
		queue.add(val);
		
		for(int i =0; i < queue.size()-1; i++) {
			
			int temp = queue.poll();
			
			queue.add(temp);
		}
		
	}
}
