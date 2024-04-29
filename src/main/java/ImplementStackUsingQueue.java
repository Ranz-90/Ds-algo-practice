import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args){

        //Algorithm is as follows for push method

        //add the value in queue first
        //iterate the queue till size -1 and add from last
        //remove last

        push(3);
        push(2);
//        /System.out.println("Top Element is " + top());
        push(4);
        push(1);

        System.out.println("Top is " + top());
        System.out.println("Popped  is " + pop());
    }

    private static int top() {
        if(queue.isEmpty()){
            return -1;
        }
        return queue.peek();
    }

    private static int pop() {
        if(queue.isEmpty()){
            return -1;
        }
        return queue.poll();
    }

    private static void push(int value) {

        queue.add(value);
        for(int i =0; i < queue.size() -1; i++){
            queue.add(queue.peek());
            queue.poll();

        }

    }
}
