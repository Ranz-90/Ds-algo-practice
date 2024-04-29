import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSUbsequencePractice2 {

    public static void main(String[] args){

        int[] input = {3, 10, 2, 1, 20};

        int maxLenSubSequence = getLongestSubsequence(input);

        System.out.println(maxLenSubSequence);

    }

    private static int getLongestSubsequence(int[] input) {

        int[] LIS = new int[input.length];
        int maxLen =0;

        for(int i=0; i < input.length; i++){
            LIS[i] =1;
        }

        for(int i =1; i <input.length; i++){
            for(int j=0; j <i; j++){
                if(input[i] > input[j] && LIS[i] < LIS[j]+1){
                    LIS[i] = LIS[j]+1;
                }
            }
        }

        for(int i=0; i <LIS.length; i++){
            if(maxLen < LIS[i]){
                maxLen = LIS[i];
            }
        }

        //Print the actual array elements from LIS array;
        List<Integer> longSubList = new ArrayList<>();
        int index = LIS.length-1;

        longSubList.add(LIS[index]);

        for(int i=index-1; i>=0; i--){
            if(LIS[i]+1 == LIS[index] && input[i] < input[index]){
                index =i;
                longSubList.add(input[i]) ;
            }
        }


        return maxLen;
    }
}
