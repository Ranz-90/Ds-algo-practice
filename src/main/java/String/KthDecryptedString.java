package String;

public class KthDecryptedString {

    public static void main(String[] args){
        String input = "a2b2c3";
        int k = 5;

        String output = getKthDecryptedString(input,k);
        System.out.println(output);

    }

    private static String getKthDecryptedString(String input, int k) {
        int size = 0;
        for(int i =0; i <input.length(); i++){

            if(Character.isDigit(input.charAt(i))){
                size = size *(input.charAt(i) - '0');
            }
            else{
                size++;
            }

        }

        for(int j = input.length()-1; j >=0; j--){
            char c = input.charAt(j);
            k = k%size;

            if(k == 0 || k == size && Character.isLetter(input.charAt(j))){
                return Character.toString(c);
            }


            if(Character.isDigit(c)){
                size = size/(c - '0');
            }
            else {
                size --;
            }
        }
        return null;
    }
}
