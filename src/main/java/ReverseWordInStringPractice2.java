public class ReverseWordInStringPractice2 {

    public static void main(String[] args){

        //String input = "hellow world";
        String input = "the   sky is  blue";

        String output = reverseWordInString(input,input.length());

        System.out.println(output);
    }

    private static String reverseWordInString(String input, int length) {

        int i =0;
        int j;
        String result ="";

        while(i < length){

            while(i < length && !Character.isLetter(input.charAt(i))){
                i++;
            }
            j =i+1;

            while(j <length && Character.isLetter(input.charAt(j))){
                j++;
            }
            String sub = input.substring(i,j);
            if(result.isEmpty()) result = sub;
            else{
                result = sub + " " + result;
            }
            i= j+1;
        }
        return result;
    }
}
