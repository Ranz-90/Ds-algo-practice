package array;

public class AmazonAssessment {

    public static void main(String[] args){
        int[] arr = {7,4,5,2,6,5};

        int out = getSum(arr,0,2);
    }


    private static int getSum(int[] arr, int start, int end) {

        int sum = 0;

        for(int i= end; i >= start; i--){
            if(arr[i] >= arr[i-1]) sum +=  arr[i];
            else if(arr[i] <= arr[i-1]) sum+= arr[i-1]-1;
        }

        return sum;
    }
}
