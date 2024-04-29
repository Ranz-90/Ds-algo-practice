package linkedlist;

public class ReverseListIterative {

    static Node head;

    static class Node{
        public int data;
        public Node next;

    public Node(int data) {
            this.data = data;
            next = null;
        }

    }

public static void main(String[] args){

        insertNode(1);
        insertNode(2);
        insertNode(3);
        //printLinkedList();
        //printLinkedListInReverseOrder(head);
        //Node reverse = reverseLinkedListByRecursion(head);
        //printLinkedList(reverse);
        Node reverse = reverseLinkedListByIterative(head);
        printLinkedList(reverse);

}

    private static Node reverseLinkedListByIterative(Node head) {
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;

    }

    private static Node reverseLinkedListByRecursion(Node head) {
        if(head.next == null || head == null){
          return head;
        }
        Node reverse = reverseLinkedListByRecursion(head.next);
         Node q = head.next;
         q.next = head;
        head.next = null;
        return reverse;
    }

    private static void printLinkedListInReverseOrder(Node head) {
        Node n = head;
        if(n == null){
            return;
        }
        printLinkedListInReverseOrder(n.next);
        System.out.println(n.data);
    }

    private static void printLinkedList(Node head) {
        Node n = head;
        while(n != null){
            System.out.println(n.data);
            n = n.next;

        }
    }

    public static void insertNode(int val){
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
}

}
