import java.util.Stack;

public class LargestRectangleInHistogram {
/*
    Find the largest rectangular area possible in a given histogram where the largest rectangle
    can be made of a number of contiguous bars.
    For simplicity, assume that all bars have same width and the width is 1 unit.
    For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}.
    The largest possible rectangle possible is 12 (see the below figure, the max area rectangle is
    highlighted in red)*/

/*    Approach: we have to calculate leftsmaller and rightsmaller array for each index
    for given index i, we will get leftSmall[i] to get what is left smaller index for that index
      and rightSmaller[i] to get what is right smaller index for that index.
    once we find out leftmaller and rightsmaller for index index
    simply apply formula (rightSmaller - leftSmaller +1) * height[i] to get area and store max
    TC---> O(n) + O(n) + O(n) = O(n).. SC --> O(2N)*/



    public static void main(String[] args)
    {
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }

    private static int getMaxArea(int[] hist, int length) {

        int[] leftSmaller = new int[length];
        int[] rightSmaller = new int[length];
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        //Step1: calculate left smaller

        for(int i =0; i <length; i++){
            //need to maintain liner increasing order in stack
            //so if value is smaller than top of stack. we will pop out till we get greater elements
            while(!stack.isEmpty() && hist[stack.peek()] >= hist[i]){
                stack.pop();
            }
            //if stack empty means we dont have any smaller means 0;
            if(stack.empty())leftSmaller[i] = 0;
            //if stack no empty
            else leftSmaller[i] = stack.peek()+1;
            stack.push(i);
        }

        //step2: pop out all elemnts before calculating right smaller
        //since we are re-using same stack we have to clear that before calculating right smaller

        while(!stack.isEmpty()) stack.pop();

        //step3: calculate Right Smaller -- for right we have to iterate from length -1 to 0

        for(int i = length-1; i >=0; i--){

            //need to maintain liner increasing order in stack
            //so if value is smaller than top of stack. we will pop out till we get greater elements
            while(!stack.isEmpty() && hist[stack.peek()] >= hist[i]){
                stack.pop();
            }

            //if stack empty means we dont have anything, so last index will be right smaller;
            if(stack.empty())rightSmaller[i] = length-1;
            else rightSmaller[i] = stack.peek()-1;
            stack.push(i);
        }

        //Step4: final
        //Once we have left and right smaller array ready
        //iterate the histogram array and apply formula for each index of histogram array
        //(right - left +1)*hist[i] -- to get area of each block, and store max accordingly

        for(int i =0; i <length-1;i++){

            int currentArea = hist[i]*(rightSmaller[i]  - leftSmaller[i] +1);
            maxArea = Math.max(maxArea,currentArea);
        }

        return maxArea;

    }
}
