public class ImplementQueueUsingArrays {

    static int QUEUE_SIZE = 5;
    static int count =0;
    static int[] array = new int[QUEUE_SIZE];
    static int front =0;
    static int rear = 0;

    public static void main(String[] args){

        push(3);
        push(2);
        push(1);
        push(8);
        push(6);

        System.out.println("Top is " + top());
pop();
pop();
pop();
        push(9);
        System.out.println("Top is " + top());

    }

    private static void pop() {
        if(count == 0){
            System.out.println("Queue is Empty cant pop ");
        }
        array[front%QUEUE_SIZE] = -1;
        front++;
        count--;

    }

    private static int top() {
        if(count == 0){
            System.out.println("Queue is Empty ");
        }
       return array[front%QUEUE_SIZE];
    }

    private static void push(int val) {

        if(count == QUEUE_SIZE-1){
            System.out.println("Queue is Full");
        }

        array[rear%QUEUE_SIZE] = val;
        rear++;
        count++;
    }
}
