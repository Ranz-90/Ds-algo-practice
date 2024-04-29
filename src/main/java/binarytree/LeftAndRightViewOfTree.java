package binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeftAndRightViewOfTree {

    static class  Node{
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
        root.left.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right.left = new Node(6);
        root.right.right = new Node(7);

        //List<Integer> leftView = leftViewOfTree(root);
        List<Integer> rightView = new ArrayList<>();
        List<Integer> leftView = new ArrayList<>();;
         rightViewOfTree(root,0,  rightView);
         leftViewOfTree(root,0,leftView);
    }

    private static void leftViewOfTree(Node root, int level, List<Integer> ds) {
        //need to do simply pre order traversal and print node when level increases for 1st time

        if(root == null){
            return;
        }

        if(level == ds.size()){
            ds.add(root.data);
        }

        leftViewOfTree(root.left, level+1,ds);
        leftViewOfTree(root.right, level+1,ds);

    }

    private static void rightViewOfTree(Node root, int level, List<Integer> ds) {

        //need to do reverse pre order traversal and print node when level increases for 1st time
        //Pre Order means --> RLR  --> reverse pre order means Root, Right, Left


        if(root == null){
            return ;
        }
        if(level == ds.size()){
            ds.add(root.data);
        }
        rightViewOfTree(root.right, level+1,ds);
        rightViewOfTree(root.left, level+1,ds);

    }
}
