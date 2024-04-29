package binarytree;

public class InOrderPredessorAndSuccssor {

    static class Node{

        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data = val;
            left= null;
            right = null;
        }
    }

    public static void main(String[] args){

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        Node temp = root.left.right.left;

        int inOrderSuccessor = getInOrderSuccessor(root,temp);

        System.out.println(inOrderSuccessor);

        int onOrderPredessor = getInOrderPredessor(root,root.left);

        System.out.println(onOrderPredessor);


    }

    private static int getInOrderSuccessor(Node root, Node temp) {

        int res =0;
        while(null != root){
            //value is higer than root so we should move rightward as we need successor
            //successor with the smallest key greater than the key of the input node.
            if(temp.data>= root.data){
                root = root.right;
            }
            else{
                res = root.data;
                root = root.left;
            }
        }
        return res;
    }

    private static int getInOrderPredessor(Node root, Node temp){

        int res = 0;

        while(null != root){

            //for predessor its reverse if value is less we will move to left we need minimum
            if(temp.data<= root.data){
                root = root.left;
            }
            else{
                res = root.data;
                root = root.right;
            }
        }
        return res;
    }
}
