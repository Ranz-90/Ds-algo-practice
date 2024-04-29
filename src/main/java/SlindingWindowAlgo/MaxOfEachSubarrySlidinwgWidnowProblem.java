package SlindingWindowAlgo;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxOfEachSubarrySlidinwgWidnowProblem {


    public static void main(String[] args){

        int[] input = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        //int[] output = {3,3,5,6,7};

        int[] output = getSlidingWindowMaximum(input,k);
        for(int num : output){
            System.out.println(num);
        }

    }

    private static int[] getSlidingWindowMaximum(int[] input, int k) {

        int[] output = new int[input.length-k+1];
        int outputIndex = 0;
        //Queue will store index of every max elements for each subbary with size k
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i =0; i <input.length; i++){
            //Remove out of boundary indexes..Lest say if u are at any index i, so we dont want
            //to cosnider i-k indexes ...so we simply remove from queue
            if(!queue.isEmpty()  && queue.peek() == i-k){
                queue.poll();
            }

            //remove all smaller elements than any elements input[i] from last

            while(!queue.isEmpty() && input[queue.peekLast()] <= input[i]){
                queue.pollLast();
            }

            //finallry for all index we have to push the current index to queue

            queue.offer(i);

            //let say if k is 3, then will start taking value from k-1 i.e 2 (0, 1, 2)
            if(i >= k-1){
                output[outputIndex] = input[queue.peek()];
                outputIndex++;
            }
        }

        return output;

    }
}
