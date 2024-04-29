package binarytree;

public class DFS {

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

            printInOrder(root);
        }

        private static void printInOrder(Node root) {

            if(root == null){
                return;
            }
            printInOrder(root.left);
            System.out.println(root.data);
            printInOrder(root.right);

        }

}
