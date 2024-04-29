package leetcode.easy;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

	public static void main(String[] args) {
		
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		getBottomView(root);
	}
	
	private static void getBottomView(Node root) {
		
		if(root == null) return;
		
		Queue<pair> queue = new LinkedList<>();
		
		Map<Integer,Integer> map = new TreeMap<>();
		
		queue.add(new pair(root,0));
		
		while(!queue.isEmpty()) {
			
			pair p = queue.poll();
			
			int data = p.getData();
			Node temp = p.getRoot();
			map.put(data, temp.data);
			
			if(temp.left != null) {
				queue.add(new pair(temp.left, data-1));
			}
			
			if(temp.right != null) {
				queue.add(new pair(temp.right, data+1));
			}
			
		}
		
		//List<Integer> output = new ArrayList<>();
		
		for(int val: map.values()) {
			System.out.println(val);
		}
		
	}

}
