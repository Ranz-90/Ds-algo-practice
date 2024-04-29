package binarytree;

public class CheckBSTOrNot {
	static class Node {

		public int data;
		Node left;
		Node right;

		public Node(int val) {
			this.data = val;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {

		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		if (isBST(root)) {
			System.out.println("BST");
		} else {
			System.out.println("Not a BST");
		}
	}

	private static boolean isBST(Node root) {

		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBSTUtil(Node root, int minValue, int maxValue) {

		// empty tree is BST so true
		if (root == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (root.data > maxValue || root.data < minValue)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		// Allow only distinct values
		else {
			return isBSTUtil(root.left, minValue, root.data - 1) && isBSTUtil(root.right, root.data + 1, maxValue);
		}
	}

}
