package binarytree;

import java.util.Stack;

public class TwoSuminBST {

    private Stack<Node> stack = new Stack<Node>();
    boolean reverse = true;

    public TwoSuminBST(Node n, boolean isReverse){
        reverse = isReverse;
        pushAll(n);
    }

    private void pushAll(Node node) {
        while(node != null){
            stack.push(node);
            if(reverse){
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    //return next smallest element
    public int next(){
        Node temp = stack.pop();
        if(!reverse) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.data;
    }

    static class Node{

        public int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args){

        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
       /* root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);*/
        int target = 28;


       boolean isFind = findTarget(root,target);
       System.out.println(isFind);
    }

    private static boolean findTarget(Node root, int target) {
        if(root == null) return false;

        TwoSuminBST l = new TwoSuminBST(root, false);
        TwoSuminBST r = new TwoSuminBST(root, true);

        int i = l.next();
        int j = r.next();

        while( i < j){
            if(i + j == target) return true;
            else if(i + j < target) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
