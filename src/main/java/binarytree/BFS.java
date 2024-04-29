package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printLevelOrderTraversal(root);
    }

    private static void printLevelOrderTraversal(Node root) {

        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            Node temp = queue.peek();
            System.out.println(temp.data);
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
            queue.poll();

        }


    }
}
