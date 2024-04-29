package array;

public class StikclerThief {

    public static void main(String[] args){
        int[] input = {5,6,10,100,10,5};
        int len = input.length;
        int val1 = input[0];
        if(len ==1){
            System.out.println(val1);
        }
        int val2 = Math.max(input[0], input[1]);
        if(len ==2){
            System.out.println(val2);
        }
        int sum;
        for(int i =2; i <len;i++){
             sum = Math.max(input[i] + val1, val2);
             val1 = val2;
             val2 = sum;
        }
    }
}
