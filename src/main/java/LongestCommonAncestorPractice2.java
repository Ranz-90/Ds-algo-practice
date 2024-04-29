public class LongestCommonAncestorPractice2 {
    static class Node{

        public int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

    }



    public static void main(String[] args){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node result = getLongestCommonAncestor(root,4,5);

        System.out.println(result.data);
    }

    private static Node getLongestCommonAncestor(Node root, int p, int q) {

        if(root == null || root.data ==p || root.data == q){

            return root;
        }

        Node left = getLongestCommonAncestor(root.left, p, q);
        Node right = getLongestCommonAncestor(root.right, p, q);

        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else{
            return root;
        }
    }
}
