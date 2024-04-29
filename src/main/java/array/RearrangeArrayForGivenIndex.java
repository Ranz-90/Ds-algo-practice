package array;

public class RearrangeArrayForGivenIndex {

    public static void main(String[] args){
        int[] input = {10,11,12};
        int[] index = {1,0,2};
        int[] temp = new int[input.length];

        for(int i=0; i <input.length; i++){
            temp[index[i]] = input[i];
        }

        for(int i =0; i < temp.length; i++){
            input[i] = temp[i];
            index[i] = i;
        }
    }
}
