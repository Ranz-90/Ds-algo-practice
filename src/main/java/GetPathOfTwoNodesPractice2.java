import java.util.ArrayList;
import java.util.List;

public class GetPathOfTwoNodesPractice2 {

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

    private static List<Integer> getPaths(Node root, int data) {

        List<Integer> listOfPaths = new ArrayList<>();

        if(getPath(listOfPaths,root,data)){
            return listOfPaths;
        }
        return listOfPaths;
    }

    private static boolean getPath(List<Integer> listOfPaths, Node root, int data) {

        if(root == null) return false;

        listOfPaths.add(root.data);

        if(root.data == data){
            return true;
        }

        if(getPath(listOfPaths, root.left, data) || getPath(listOfPaths, root.right, data)){
            return true;
        }

        listOfPaths.remove(listOfPaths.size()-1);
        return false;
    }


}
