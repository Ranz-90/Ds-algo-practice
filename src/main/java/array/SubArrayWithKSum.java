package array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKSum {

    public static void main(String[] args)
    {
        int arr[] = { 10, 2, -2, -20, 10 };
        int sum = -10;
        int n = arr.length;

        /*        Output : 3
        Subarrays: arr[0 to 3], arr[1 to 4], arr[3 to 4]
        have sum exactly equal to -10.*/

/*        Input2 : arr[] = {9, 4, 20, 3, 10, 5},
        k = 33
        Output : 2
        Subarrays : arr[0...2], arr[2...4] have sum
        exactly equal to 33.*/
        System.out.println(findSubarraySum(arr, n, sum));
    }

    private static int findSubarraySum(int[] arr, int len, int sum) {
        int maxLen = 0;
        int curSum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i <len; i++){
            curSum = curSum + arr[i];

            if(curSum == sum){
                maxLen++;
            }

            if(map.containsKey(curSum - sum)){
                maxLen = maxLen + map.get(curSum - sum);
            }

            map.put(curSum,map.getOrDefault(curSum,0)+1);
        }
        return maxLen;
    }
}
