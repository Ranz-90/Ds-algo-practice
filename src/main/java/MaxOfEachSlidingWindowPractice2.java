import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxOfEachSlidingWindowPractice2 {

    public static void main(String[] args) {

        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        //int[] output = {3,3,5,6,7};

        int[] output = getSlidingWindowMaximum(input, k);
        for (int num : output) {
            System.out.println(num);
        }
    }

    private static int[] getSlidingWindowMaximum(int[] input, int k) {

        int len = input.length;
        int[] output = new int[len-k+1];
        int outputIndex =0;

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i =0; i < len; i++){

            while(!queue.isEmpty() && queue.peek() == i-k){
                queue.poll();
            }

            while(!queue.isEmpty() && input[queue.peekLast()] <= input[i]){
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k-1){
                output[outputIndex++] = input[queue.peek()];
            }
        }

        return output;
    }
}
