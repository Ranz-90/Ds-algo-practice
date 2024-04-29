package Day2;

import java.util.HashMap;
import java.util.Map;

public class MakeBSTFromInorderAndPreOrder {
	
	static class Node{
		
		int data;
		Node left;
		Node right;
		
		public Node(int val) {
			this.data = val;
			left = null;
			right = null;
					
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		Node root = buildTheTree(preorder, inorder);
		
	}

	private static Node buildTheTree(int[] preorder, int[] inorder) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i =0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		
		Node root = getTheTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
		return root;
	}

	private static Node getTheTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> map) {
		
		if(preStart > preEnd || inStart > inEnd) return null;
		
		Node root = new Node(preorder[preStart]);
		
		int inRoot = map.get(root.data);
		
		int numsLeft = inRoot - inStart;
		
		root.left = getTheTree(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,map);
		root.right = getTheTree(preorder,preStart+numsLeft+1, preEnd,inorder,inRoot+1,inEnd,map);
		
		return root;
	}

}
