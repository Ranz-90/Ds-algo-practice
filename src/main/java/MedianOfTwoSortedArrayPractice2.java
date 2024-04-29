public class MedianOfTwoSortedArrayPractice2 {
    public static void main(String[] args){

        int[] num1 = {-5, 3, 6, 12, 15};
        int[] num2 = {-12, -10, -6, -3, 4, 10};

        int median = getMedian(num1,num2);

        System.out.println(median);
    }

    private static int getMedian(int[] num1, int[] num2) {

        if(num1.length > num2.length)return getMedian(num2,num1);
        int low =0;
        int n1 = num1.length;
        int n2 = num2.length;
        int high = n1;

        while(low<=high){

            int cut1 = low+high/2;
            int cut2 = (n1+n2+1)/2 -cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : num1[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : num2[cut2-1];

            int r1 = cut1 == n1-1 ? Integer.MAX_VALUE : num1[cut1];
            int r2 = cut2 == n2-1? Integer.MAX_VALUE : num2[cut2];

            if(l1 <= r2 && l2 <= r1){
                if(n1+n2%2 ==0){

                   return (Math.min(r1,r2) + Math.max(l1,l2))/2;
                }
                else{
                    return Math.max(l1,l2);
                }
            }

            if(l1 >=r2){
                high = cut1-1;
            }
            else{
                low = cut1+1;
            }

        }
        return 0;
    }

}
