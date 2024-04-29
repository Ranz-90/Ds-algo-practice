public class TappingRainWaterproblem {

    //The question will be you will be giving a array with intergers
    //each index denotes the heoight of rectange for that index
    //You have to calculate maximum unit of water can logged in that structure

    //output will be 6 if we draw that picture you will understand

    //The algorithm will be
    //1) for each index calculate leftMax and RightMax
    //leftmax for index i is max of i to 0;
    //rightmax for index i will be max of i to n-1 index
    //then for each index the unit of water will Min(leftMax, rightmax) - a[i]

    //Solution 1:  calulate leftMax and rightmax everytime for each index  , TC -- will be O(n*n)
    //Solution2: O(n) but space will be O(2N) coz we will be storing left and right max in two diff array

    //Trick : is to calculate leftmax iterate from 0 to n-1 and store maximum
    //Trick :  to calculate rihhtmax iterate from n-1 to 0 store maximum


    public static void main(String[] args){
        int[] input = {0,1,2,2};
        int output = getMaxUnitWater(input, input.length);
        System.out.println(output);
    }

    private static int getMaxUnitWater(int[] array, int n) {

        int[] leftMax = getLeftMax(array,0,n);
        int[] rightMax = getRightMax(array,0, n-1);
        int totalUnitOfWater =0;

        for(int i =0; i <n; i++){
            //for each index calculate min of leftMost and rightMost
            int curMin = Math.min(leftMax[i], rightMax[i]);
            //If curMin is greater than the current value i.e array[i], then only water can be logged
            if(curMin > array[i]){
                int waterTapped = curMin - array[i];
                totalUnitOfWater = totalUnitOfWater+waterTapped;
            }
        }
        return totalUnitOfWater;
    }

    private static int[] getRightMax(int[] array, int start, int end) {
        int[] rightMaxArray = new int[end+1];
        int curMax = 0;
        while(end >= start){
            if(curMax < array[end]){
                curMax = array[end];
            }
            rightMaxArray[end] = curMax;
            end--;

        }
        return rightMaxArray;

    }

    private static int[] getLeftMax(int[] array, int start, int end) {

        int[] leftMaxArray = new int[end];
        int curMax = 0;
        while(start < end){
            if(curMax < array[start]){
                curMax = array[start];
            }
            leftMaxArray[start] = curMax;
            start++;

        }
        return leftMaxArray;
    }


}
