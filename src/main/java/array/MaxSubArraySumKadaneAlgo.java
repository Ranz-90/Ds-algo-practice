package array;

public class MaxSubArraySumKadaneAlgo {

/*    Lets take the example:
    {-2, -3, 4, -1, -2, 1, 5, -3}
    Maximum contiguous sum is 7 for subarray {4, -1, -2, 1, 5}*/

    public static void main(String[] args){

        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};

        int output = getMaxContiguousSum(input, input.length);
        System.out.println(output);

    }

    private static int getMaxContiguousSum(int[] input, int length) {

        int sum = 0;
        int max = 0;

        for(int i =0; i < length; i++){

            sum = sum + input[i];
            max = Math.max(max, sum);
            if (sum < 0) sum =0;
        }

        return max;
    }
}
