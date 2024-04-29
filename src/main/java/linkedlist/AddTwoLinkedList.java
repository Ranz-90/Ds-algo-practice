package linkedlist;

public class AddTwoLinkedList {

    static Node head1;
    static Node head2;

    static class Node{

        int data;
        Node next;
        public Node(int val){
        this.data = val;
        next = null;
        }

        public Node(){

        }
    }

    public static void main(String[] args){

        buildList1(3);
        buildList1(4);
        buildList1(2);

        buildList2(4);
        buildList2(6);
        buildList2(5);
        
        Node addedHead = add(head1, head2);
        printLinkedList(addedHead);
    }

    private static void printLinkedList(Node head) {
        Node n = head;
        while(n != null){
            System.out.println(n.data);
            n = n.next;

        }
    }

    private static Node add(Node head1, Node head2) {

        Node dummyNode = new Node();
        Node temp = dummyNode;
        int carry = 0;

        //Iterate if any of list is not null or carry is not zero
        //coz it might happen if both list is null
        //we stil may have carry left after addition which needs to be added
        while(head1 != null || head2 != null || carry > 0){
            //sum wll be initialized to 0 for every iteration
            int sum =0;

            if(head1 != null){
                sum = sum + head1.data;
                head1 = head1.next;
            }

            if(head2 != null){
                sum = sum + head2.data;
                head2 = head2.next;
            }

            //once added both elemnts of list make sure to add carry
            //and always reinitialize carry to sum /10
            //while creating new node make sure pass sum%10 to store the reminder alsways
            sum = sum + carry;
            carry = sum /10;
            Node newNode = new Node(sum%10);
            //move temp next to new node
            temp.next = newNode;
            //finally temp withh be new Node to make sure temp is pointing to new node always
            temp = newNode;
        }

        return dummyNode.next;

    }

    private static void buildList1(int val) {
        Node temp1 = new Node(val);
        temp1. next = head1;
        head1 = temp1;
    }

    private static void buildList2(int val) {
        Node temp2 = new Node(val);
        temp2. next = head2;
        head2 = temp2;
    }

}
