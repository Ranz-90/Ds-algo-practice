import java.util.Stack;

public class ImplementQueueUsingStack {

    //Algorithm: for Push method ---> O(1)---Need two stack input and output stack

    //Step1: for push method simply push the value to input stack

    //Algorithm for :for top() method --->O(n)

    //check if output stack is not empty , if so simply return output.top()
    //otherwise push all from input to output and then return output.top();


    //Algorithm for :for pop() method --->O(n)

    //check if output stack is not empty , if so simply return output.pop()
    //otherwise push all from input to output and then return output.pop();

    static Stack<Integer> input = new Stack<>();
    static Stack<Integer> output = new Stack<>();

    public static void main(String[] args){

        push(2);
        push(5);
        push(3);

        System.out.println("Top is " + top());
        System.out.println("Popped  is " + pop());
        push(6);
        System.out.println("Popped  is " + pop());
        System.out.println("Popped  is " + pop());
        System.out.println("Top is " + top());

    }

    private static int top() {
        if(!output.isEmpty()){
            return output.peek();
        }
        else{

            while(!input.isEmpty()){
                output.push(input.pop());
            }
            return output.peek();
        }
    }

    public static void push(int value){
        input.push(value);
    }

    public static int pop(){

        if(!output.isEmpty()){
            return output.pop();
        }
        else{

            while(!input.isEmpty()){
                output.push(input.pop());
            }
            return output.pop();
        }
    }

}
