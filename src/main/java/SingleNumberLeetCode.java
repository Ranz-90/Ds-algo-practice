import java.util.Arrays;

public class SingleNumberLeetCode {

    public static void main(String[] args){

        int[] num = {2,2,1};

        int output = getSingleNumber(num, num.length);

        System.out.println(output);
    }

    private static int getSingleNumber(int[] num, int length) {

        Arrays.sort(num);

        int i =0;

        int single =0;

        for(int j =1; j <length; j++){
            int cur = num[i];
            if(cur != num[j]){
                single = num[j];
                i=j;
            }
        }

        return single;
    }
}
