package binarytree;

public class MorrisInorderTraversal {

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
        root.left.right.right = new Node(6);

        printMorrisInOrderTraversal(root);
    }

    private static void printMorrisInOrderTraversal(Node root) {

        Node cur = root;
        while(cur != null){


            //Condition1 : if left is null then simply move right and print the root value
            //as we are doing in order if nothing is there in left root has to be printed after that before right
            if(cur.left == null){
                System.out.print(cur.data);
                cur = cur.right;
            }

            else{
                Node temp = cur.left;

                //Other wise if left sub tree is not null
                //iterate the rihght most of Left subtree with one extra condition while moving to rihght
                //if the value of any right node is not equals to the current node
                while(temp.right != null && temp.right!= cur){
                    temp = temp.right;
                }

                //the momemt we reach right most
                //create a pointer to pointer from right most; thas the main idea of morris
                if(temp.right == null){
                    temp.right = cur;
                    cur = cur.left;
                }
                else{
                    temp.right = null;
                    System.out.print(cur.data);
                    cur = cur.right;

                }
            }
        }
    }
}
