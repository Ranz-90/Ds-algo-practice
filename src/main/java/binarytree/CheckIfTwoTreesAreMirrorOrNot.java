package binarytree;

public class CheckIfTwoTreesAreMirrorOrNot {


    public static void main(String[] args){

        Node roota = new Node(1);
        Node rootb = new Node(1);
        roota.left = new Node(2);
        roota.right = new Node(3);
        roota.left.left = new Node(4);
        roota.left.right = new Node(5);

        rootb.left = new Node(3);
        rootb.right = new Node(2);
        rootb.right.left = new Node(5);
        rootb.right.right = new Node(4);

        if (areMirror(roota, rootb) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean areMirror(Node roota, Node rootb) {

        //Base CAse 1: if both tree are empty return true;

        if(roota == null && rootb == null) return true;
        //Base Case 2: if any of tree is empty return false
        if(roota == null || rootb == null) return false;
        /* Both non-empty, compare them recursively
           Note that in recursive calls, we pass left
           of one tree and right of other tree */
        else{
            return roota.data == rootb.data
                    && areMirror(roota.left, rootb.right)
                    && areMirror(roota.right, rootb.left);
        }
    }
}

 class Node{

    int data;
    Node left;
    Node right;

    public Node(int val){
        this.data = val;
        left = null;
        right = null;
    }
}
