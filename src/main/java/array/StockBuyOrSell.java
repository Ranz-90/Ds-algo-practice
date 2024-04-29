package array;

import java.util.ArrayList;

public class StockBuyOrSell {

    public static void main(String[] args){
        int[] input = {100,180,260,310,40,535,695};
        //output = {0,3} , {4,6}

        stockBuySell(input, input.length);


    }
    static ArrayList<ArrayList<Integer>> stockBuySell(int[] arr, int n) {
        int left = 0;
        int right = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(right<arr.length-1){
            while(right<arr.length-1 && arr[right+1] > arr[right])right++;
            if(left==right){
                left++;
                right++;
                continue;
            }
            ArrayList<Integer> current = new ArrayList<>();
            current.add(left);
            current.add(right);
            res.add(new ArrayList<>(current));
            left = right+1;
            right++;
        }
        return res;
    }
}
