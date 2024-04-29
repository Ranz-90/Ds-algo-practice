package String;

public class PermutationOfGivenString {

    public static void main(String[] args){

        String input = "ABC";

        doPermute(input,0,input.length()-1);
    }

    private static void doPermute(String input, int l, int r) {

        if(l == r ){
            System.out.println(input);
        }
        else{
            for(int i =l; i <= r; i++){
                input = swap(input, l, i);
                doPermute(input, l+1, r);
                input = swap(input, l, i);
            }
        }
    }

    private static String swap(String input, int i, int j) {

        char[] charArray = input.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }
}
