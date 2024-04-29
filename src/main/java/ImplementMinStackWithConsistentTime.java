import java.util.Stack;

public class ImplementMinStackWithConsistentTime {

    //The task is to design a stack ds which support push pop top and getMin() with O(1) TC


    //Only for C++
    //Can be solved using Stack of pair integers by SC will 2(N) as we will
    //Store current value and current min in top of stack


    //Ideal approach for java with TC-->O(1) and SC-->O(N)
     Stack<Integer> minStack = new Stack<>();
     int min;

    public ImplementMinStackWithConsistentTime() {
        min = Integer.MAX_VALUE;
    }

    public void push(int val){

        //1st Push(-2) ---- will come and it falss in this if condition
        //min will be updated with the val as well
        if(minStack.isEmpty()){
            min = val;
            minStack.push(val);
        }

        //3rd Push(-3) ----> Very very important part
        //here if val -3 is lesser than min i.e -2
        //So we are modifying the actual value which is -3 to 2*-3 - (-2) = -4
        //Why 2*val - min works is
        //If val < min --> val -min < 0 --> val + val -min < 0+val (adding val in both side) --> 2*val -min < val

        else{
            if(val < min){
                minStack.push(2*val - min);
                min = val;
            }

            //in 2nd push(0)
            //it will come else block as the value 0 is not lesser tha min i.e. -2
            else{
                minStack.push(val);
            }
        }

    }

    public void pop(){

        //while popping if stack is empty simply return or print stack is empty
        if(minStack.isEmpty()) return;

        //when stack is not empty
        //here popped will be 2*val - min , coz for -3 val we pust 2*-3 - (-2) = -4
        //but -4 is not the actual value , so we need to restore min back to previous min
        //before -3 min was -2, so while popping -4 make sure we reverted back min to -2
        int popped = minStack.pop();

        //popped will always less than min..coz we inserted modified value for -3 we insert -4
        //so to restore back min apply formula min = 2*min - stack.pop(), stack.pop will be -4
        //min = 2*min - st.pop() --> 2*-3 - (-4) = -6+4 ..> -2 i.e nothng previous min
        //this formula works coz... 2*min - st.pop() --> st.pop is nothing but val means 2*val-previousMin
        //so 2*val -min can be written as 2*min(coz val will be min) - previousMin
        //so updated equation is 2*min - (2*min -previousMin) == previousMean;
        if(popped < min) {
            min = 2 * min - popped;
        }
    }

    public int top(){

        if(minStack.isEmpty()) return -1;
        int top = minStack.peek();
        //if current top is modified simply return current minimum ..
        //consider example when top is -4 , it should return current min which is -3
        // not the modified value that is -4
        if(top < min){
            return min;
        }
        //othwersie simply return the actual value from top of stack
        else{
            return top;
        }
    }

    public int getMin(){
        return min;
    }

    public static void main(String[] args){
        ImplementMinStackWithConsistentTime minStackObj = new ImplementMinStackWithConsistentTime();
        minStackObj.push(-2);
        minStackObj.push(0);
        minStackObj.push(-3);

    }
}
