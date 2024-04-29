package binarytree;

import java.util.ArrayList;
import java.util.List;

public class GetPathOfTwoNodes {
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
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> finalList = getPaths(root,7);

        if(null != finalList && !finalList.isEmpty()){
            finalList.forEach( i -> System.out.println(i));
        }

    }

    private static List<Integer> getPaths(Node root, int p) {

        List<Integer> list = new ArrayList<>();

        if(isPathExist(root,p,list)){
            return list;
        }
        else{
            System.out.println("No Paths exist");
            return null;
        }

    }

    private static boolean isPathExist(Node root, int p, List<Integer> outputList) {

        if(root == null){
            return false;
        }

        outputList.add(root.data);

        if(root.data == p){
            return true;
        }

        if(isPathExist(root.left,p,outputList) || isPathExist(root.right,p,outputList)){

            return true;
        }

        outputList.remove(outputList.size()-1);
        return false;

    }

}
