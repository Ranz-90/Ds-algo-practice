package linkedlist;

public class MergeTwoLinkedListInPlace {

    static Node head1;
    static Node head2;

    static class Node{
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }

    }

    public static void main(String[] args){

        buildList1(6);
        buildList1(2);
        buildList1(1);

        buildList2(8);
        buildList2(5);
        buildList2(3);

        Node mergedHead = mergetTwoList(head1,head2);

        printList(mergedHead);


    }

    private static void printList(Node mergedHead) {

        while(mergedHead != null){
            System.out.println(mergedHead.data);
            mergedHead = mergedHead.next;
        }
    }

    private static Node mergetTwoList(Node head1, Node head2) {

        if(head1 == null) return head2;
        if(head2 == null) return head1;

        //Basically head1 should always point to lower valued list
        //if head2 is havig smaller then head1 will be swapped with head2 to make sure head1 alwys points to
        //smaller elemensts
        if(head1.data > head2.data){
            Node temp = head1;
            head1 = head2;
            head2 = temp;

        }
        //we will return the head1 finally and hence storing it, head1 will be manipulated accordingly
        Node res = head1;

        while(head1 != null && head2 != null){
            Node temp2 = null;
            //Iterate head1 till its values are smaller than head2
            //The meonent it find grater it will point to head2 thru temp2 by temp2.next = head2;

            while(head1 != null && head1.data <= head2.data){
                temp2 = head1;
               head1 = head1.next;
            }
            //
            temp2.next = head2;

            Node temp3 = head1;
            head1 = head2;
            head2 = temp3;

        }

        return res;
    }

    public static void buildList1(int val){

        Node temp1 = new Node(val);
        temp1.next = head1;
        head1 = temp1;

    }

    public static void buildList2(int val){

        Node temp2 = new Node(val);
        temp2.next = head2;
        head2 = temp2;

    }
}
