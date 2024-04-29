package array;

public class SegretaeOddEvenInArray {

    public static void main (String[] args)
    {
        int arr[] = {12, 34, 45, 9, 8, 90, 3};

        segregateEvenOdd(arr);

        System.out.print("Array after segregation ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
    }


    //Algorithm is
    //increment low pointer till get qstodd number
    //decrement right till it gets 1st even number
    //finally if low < high simply swap low with high
    private static void segregateEvenOdd(int[] arr) {

        int low = 0;
        int high = arr.length-1;

        while(low < high){
            while(arr[low]%2 ==0 && low < high){
                low++;
            }
            while(arr[high]%2 ==1 && low < high){
                high--;
            }

            if(low < high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
    }
}
