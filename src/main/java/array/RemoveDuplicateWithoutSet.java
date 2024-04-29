package array;

public class RemoveDuplicateWithoutSet {

    public static void main(String[] args){

        int[] input = {1,1,2,2,3,3,3,};

/*        we are going to solve this by this two pointer approach
                i =0; and j =1;
                and we will keep checking input[i] != input[j] , if so increment i = i+1;
                and swap input[i] input[j];
                and after foor loop return i+1 which will be no of uniqueue elements*/

        int output = removeDuplicates(input);

        System.out.println(output);
    }

    private static int removeDuplicates(int[] input) {

        int i =0;
        int len = input.length;

        for(int j =1; j <len; j++){
            if(input[i] != input[j]){
                i++;
                input[i] = input[j];
            }
        }
        return i +1;
    }
}
