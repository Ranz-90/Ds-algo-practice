package array;

public class MedianOfTwoSortedArrayMostEfficient {

    public static void main(String[] args){
/*
        int[] num1 = {-5, 3,6,12,15};
        int[] num2 = {-12,-10,-6,-3,4,10};*/

/*        int[] num1 = {2,3,5,8};
        int[] num2 = {10,12,14,16,18,20};*/

/*        int x = 3;
        int y = 2;

        int z = x+y;

        double m = (double)z/2;*/

        int[] num1 = {1,2};
        int[] num2 = {3,4};

        double median = getMedian(num1,num2);

        System.out.println(median);
    }

    private static double getMedian(int[] num1, int[] num2) {

        if(num1.length > num2.length) return getMedian(num2, num1);

        int n1 = num1.length;
        int n2 = num2.length;

        int low =0;
        int high = n1;

        while(low <= high){

            int cut1 = (low +high)/2;
            int cut2 = (n1+n2+1)/2 - cut1;

            int l1 = cut1 ==0? Integer.MIN_VALUE : num1[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : num2[cut2-1];

            int r1 = cut1 == n1? Integer.MAX_VALUE : num1[cut1] ;
            int r2 = cut2 == n2? Integer.MAX_VALUE : num2[cut2];

            if(l1 <=r2 && l2<= r1 ){

                //for even length; means if total size of tow array is even num
                if((n1+n2)%2 ==0){
                    return (double)(Math.min(r1,r2) + Math.max(l1,l2))/2;
                }

                //if its odd
                else{
                    return (double)Math.max(l1,l2);
                }
            }

            //move left
            if(l1 >=r2){
                high = cut1-1;
            }

            //move right
            else{
                low = cut1+1;
            }
        }
        return 0;
    }
}
