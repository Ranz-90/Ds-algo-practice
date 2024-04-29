package array;

public class PairWithClosetSumOfGivenValue {


/*    1) Initialize a variable diff as infinite (Diff is used to store the
            difference between pair and x).  We need to find the minimum diff.
2) Initialize two index variables l and r in the given sorted array.
            (a) Initialize first to the leftmost index:  l = 0
            (b) Initialize second  the rightmost index:  r = n-1
            3) Loop while l < r.
            (a) If  abs(arr[l] + arr[r] - sum) < diff  then
    update diff and result
            (b) If(arr[l] + arr[r] <  sum )  then l++
            (c) Else r--*/
    public static void main(String[] args){

        int arr[] =  {10, 22, 28, 29, 30, 40};
                int sum = 54;
        int n = arr.length;
        printClosest(arr, n, sum);
    }

    private static void printClosest(int[] arr, int n, int sum) {
        int low=0;
        int high = n-1;
        int diff = Integer.MAX_VALUE;
        int index1 =0;
        int index2 =0;

        while(high >= low){

            if(Math.abs(arr[high] + arr[low] -sum ) < diff){
                diff = Math.abs(arr[high] + arr[low] -sum );
                index1= low;
                index2= high;
            }
            if(arr[high] + arr[low] < sum){
                low++;
            }
            else{
                high--;
            }
        }

        System.out.println("Pairs are.." +arr[index1] + " "+ arr[index2]);
    }
}
