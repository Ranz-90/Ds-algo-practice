package linkedlist;

public class RotateLinkedListByKthPlace {

    static Node head;

    static class Node{
        public int data;
        Node next;

        public Node(int val){
            this.data = val;
            next = null;
        }
    }

    public static void main(String[] args){

       insertNode(1);
        insertNode(2);
        insertNode(3);
        insertNode(4);
        insertNode(5);

        //k can be more than the linked list size
        int k = 8;

        Node rotatedHead = doRotateByKthPlaces(head,k);

    }

    private static Node doRotateByKthPlaces(Node head, int k) {

        if(null == head || head.next == null || k==0) return head;

        //1st step calculate the size of linked list
        int len =1;
        Node temp = head;
         while(temp.next != null){
             len++;
             temp = temp.next;
         }

         //2nd Step:
         //We have to always make sure that the last node will point to head that is 1st node of original list
        temp.next = head;

        //This is basically to reducing the number of rotations to optimize the code
        //as k can be more than list size;
        //Example : if list size is 5 , then for value of any 5 miltipler i.e. 10,15,20,25 etc
        //the rotated list would be same only, in that case we dont rotate at all
        //Othwersie if size is 5 and k is let say 12 so basically 12%5 --> 2 we have to 2 rotations instead of 12
         k = k%len;

         //1--2-->3-->4--5
        //For this list if k is 3 that means it would be 4-->5-->1-->2--3-->null
        //so if we carefully observe after len-k that is 5-2 = 3..
        // if we iterate till len-k i.e 3 times and make that Node.next(which is 3 in original list) ==null (Line 69)
        //before making Node.next == null, we have to point head = currNode(3).next that is 4, so head will point to 4 (Line 68)

         k = len -k;

         while( k >0){
             temp = temp.next;
             k--;
         }

         head = temp.next;
         temp.next = null;

         return head;

    }

    private static void insertNode(int value) {
        Node temp = new Node(value);
        temp.next = head;
        head = temp;
    }
}
