package hackerrank;

public class Problem1 {

    public static void main(String[] args){


        int[] input = {3,4,21,36,10,28,35,5,24,42};
        int maxRecordBroken=0;
        int minRecordBroken = 0;
        int maxRecord = input[0];
        int minRecord = input[0];

        for (int i =1; i < input.length; i++){
            if(maxRecord < input[i]){
                maxRecordBroken++;
                maxRecord = input[i];
            }
            else if(minRecord > input[i]){
                minRecordBroken++;
                minRecord = input[i];

            }
        }
        System.out.println("Max Record Brokes  " +maxRecordBroken + "Min Record Broken" + minRecordBroken );
    }



}
