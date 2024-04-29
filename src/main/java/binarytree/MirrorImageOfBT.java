package binarytree;

public class MirrorImageOfBT {

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

    public static void main(String[] args){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node mirror = doMirror(root);
    }

    private static Node doMirror(Node root) {

        if(root == null){
            return root;
        }

        Node leftMirror = doMirror(root.left);
        Node rightMirror = doMirror(root.right);

        root.left = rightMirror;
        root.right =leftMirror;
        return root;
    }

}
