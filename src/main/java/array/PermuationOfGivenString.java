package array;

public class PermuationOfGivenString {

    public static void main(String[] args){

        String str = "ABC";

        doPermute(str,0,str.length());
    }

    private static void doPermute(String str, int l, int r) {

        if(l ==r ){
            System.out.println(str);
        }

        else{
            for(int i=l ; i <r; i++){

                str= swap(str, i,l);
                doPermute(str, l+1,r);
                str = swap(str, i,l);
            }
        }

    }

    private static String swap(String str, int i, int j) {

        char[] charArray = str.toCharArray();

        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }
}
