package binarytree;

import java.util.Stack;

public class BFSInSpiralForm {

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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        printLevelOrderinSpiralForm(root);
    }

    private static void printLevelOrderinSpiralForm(Node root) {

        Stack<Node> S1 = new Stack<>();
        Stack<Node> S2 = new Stack<>();

        S1.push(root);

        while(!S1.isEmpty() || !S2.isEmpty()){

            while(!S1.isEmpty()){
                Node temp1 = S1.peek();
                System.out.println(temp1.data);
                S1.pop();
                if(temp1.right != null) S2.push(temp1.right);
                if(temp1.left != null) S2.push(temp1.left);
            }

            while(!S2.isEmpty()){
                Node temp2 = S2.peek();
                System.out.println(temp2.data);
                S2.pop();
                if(temp2.left != null) S1.push(temp2.left);
                if(temp2.right != null) S1.push(temp2.right);
            }

        }



    }
}
