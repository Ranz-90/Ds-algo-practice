package array;

public class BinarySerachInSortedRotatedArray {

    public static void main(String[] args){

        int[] input = {4,5,6,7,0,1,2};
        int target = 1;
        int len = input.length;

        int outputIndex = findElement(input,0,len-1,target);
        System.out.println(outputIndex);
    }

    private static int findElement(int[] input, int low, int high, int target) {

        while(low <= high){
            int mid = (low+high)/2;

            if(input[mid] == target){
                return mid;
            }

            if(input[low] <= input[mid]){
                if(input[low] <= target && target <= input[mid]){
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }

            else{
                if(input[mid] <= target && target <= input[high]){
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}
