package binarytree;

import java.util.Stack;

public class TwoSumBSTPractice2 {

    boolean reverse;
    Stack<Node> stack = new Stack<>();

    public TwoSumBSTPractice2(boolean reverse,Node root) {
        this.reverse = reverse;
        pushAll(root);
    }

    private void pushAll(Node root) {
        while(root!= null){
            stack.push(root);
            if(reverse) root = root.right;
            else {
                root = root.left;
            }
        }
    }

    public int next(){
        Node n = stack.pop();

        if(!reverse) pushAll(n.right);
        else pushAll(n.left);

        return n.data;
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

        TwoSumBSTPractice2 left = new TwoSumBSTPractice2(false,root);
        TwoSumBSTPractice2 right = new TwoSumBSTPractice2(true,root);

        int l = left.next();
        int r = right.next();

        while(l < r){
            if(l + r == target)return true;
            if(l +r < target) l = left.next();
            else r = right.next();
        }
        return false;
    }


}
