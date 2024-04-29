package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		getTopView(root);
	
	}

	private static void getTopView(Node root) {
		
		if(root == null) return;
		
		Queue<pair> queue = new LinkedList<>();
		
		Map<Integer,Integer> map = new TreeMap<>();
		
		queue.add(new pair(root,0));
		
		while(!queue.isEmpty()) {
			
			pair p = queue.poll();
			
			int data = p.getData();
			Node temp = p.getRoot();
			
			if(map.get(data) == null) {
				map.put(data, temp.data);
			}
			
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

class pair{
	
	Node root;
	int data;
	
	
	public pair(Node root, int data) {
		this.root = root;
		this.data = data;
	}


	public Node getRoot() {
		return root;
	}


	public int getData() {
		return data;
	}
	
	
}

 class Node{
	
	int data;
	Node left;
	Node right;
	
	public Node(int val) {
		this.data = val;
		left = null;
		right = null;
	}
}
