package array;

import java.util.HashMap;
import java.util.Map;

public class MaxLenSubArrayWith0Sum {

    public static void main(String[] args)
    {
        //Find out subarray with maximum length whose sum is 0;
/*
        Explanation: The longest sub-array with
        elements summing up-to 0 is {-2, 2, -8, 1, 7}*/

        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        int n = arr.length;
        System.out.println(findMaxSubarrayWith0Sum(arr, n));
    }

    private static int findMaxSubarrayWith0Sum(int[] arr, int len) {

        int maxLen =0;
        int sum =0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i <len; i++){

            sum = sum + arr[i];

            if(sum == 0){
                maxLen = i+1;
            }
            else{
                if(map.get(sum) != null)
                {
                    maxLen = Math.max(maxLen, i -map.get(sum));
                }
                else{
                    map.put(sum,i);
                }
            }

        }
        return maxLen;
    }

}
