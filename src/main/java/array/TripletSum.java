package array;

import java.util.HashMap;

public class TripletSum {

    public static void main(String[] args){

        //int[] input = {9, 4, 20, 3, 10, 5};
        int[] input = {10 , 2, -2, -20, 10};
        int N = input.length;
        int k = -10;

        HashMap<Integer , Integer> map = new HashMap<>();
        int curSum = 0;
        int count = 0;
        for(int i = 0; i<N; i++){
            curSum += input[i];

            if(curSum == k){
                count++;
            }


            if(map.containsKey(curSum - k)){
                int freq = map.get(curSum - k);
                count = count + freq;
            }

            map.put(curSum , map.getOrDefault(curSum , 0) + 1);
        }
        System.out.println(count);
    }
}
