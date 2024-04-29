package Day2;
public class KthLargestSmallestinBST {
	
	static int smallest = 0;
	static int counter = 0;

	public static void main(String[] args) {
      
		//int arr[]={10,40,45,20,25,30,50};
		int[] arr = {2,1,3};
		Node root = null;
		
		for(int i =0 ; i <arr.length; i++) {
			root = insertBSt(root,arr[i]);
		}
		 
		 int k =2;
		 
		 Node kthSmallest = getKthSmallest(root,new int[] {k});
		 Node kthLargest = getKthLargest(root,new int[] {k});
		 
		 System.out.println("Kth Smalest is " + kthSmallest.data);
		 System.out.println("Kth largest is " + kthLargest.data);

	}



	private static Node getKthSmallest(Node root, int[] k) {
		

		if(root == null) {
			return null;
		}
		
		Node left = getKthSmallest(root.left, k);
		if(left != null) {
			return left;
		}
		k[0]--;
		
		if(k[0] ==0) {
			return root;
		}
		
		return getKthSmallest(root.right, k);
	}



	private static Node getKthLargest(Node root, int[] k) {
		if(root == null) {
			return root;
		}
		
		Node right = getKthLargest(root.right,k);
		if(right != null) {
			return right;
		}
		k[0]--;
		if(k[0] == 0) {
			return root;
		}
		
		return getKthLargest(root.left,k);
	}



	private static Node insertBSt(Node root, int val) {
		
		if(root == null) {
			return new Node(val);
		}
		
		if (val < root.data) {
			root.left = insertBSt(root.left, val);
		}
		else {
			root.right = insertBSt(root.right, val);
		}
		
		return root;
	}



	static class Node{
		
		int data;
		Node left;
		Node right;
		
		public Node(int val){
		
			this.data = val;
			left = null;
			right = null;
		}
	}
	

}
