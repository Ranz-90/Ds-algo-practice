package array;

public class SmallestMissingPositive {

    public static void main(String[] args){

        int[] input = {-1,1,3,4,1};

        int output = getSmallestMissingPositive(input, input.length);
        System.out.println("Smallest Missing Positive is " + output);
    }

    private static int getSmallestMissingPositive(int[] input, int length) {

        boolean contains_one = false;
        for(int i =0; i < length; i++){
            if(input[i] == 1){
                contains_one = true;
                break;
            }
        }

        if(!contains_one) return 1;

        if(length == 1) return 2;

        for(int i =0; i < length; i++){
            if(input[i] <= 0 || input[i] > length) input[i] = 1;
        }

        for(int i = 0; i < length; i++){
            int x = Math.abs(input[i]);
            if(input[x-1] > 0) input[x-1] = (-1*input[x-1]);
        }

        for(int i = 0; i <length ; i++){
            if(input[i] > 0){
                return i+1;
            }
        }
        return length +1;
    }

}
