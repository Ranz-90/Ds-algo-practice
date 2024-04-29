package String;

public class ReverseWordInString {

    //input is "Hellow world" --> can conatin any number of spaces
    //output will be world Hellow

    //input is the sky is blue;
    //ouput will be blue is sky the

    public static void main(String[] args){

        //String input = "hellow world";
        String input = "the   sky is  blue";

        String output = reverseWordInString(input,input.length());

        System.out.println(output);
    }

    private static String reverseWordInString(String input, int length) {
        String result = "";
        int i =0;

        //iterate string till it not space
        while(i < length){
            while(i < length && !Character.isLetter(input.charAt(i)))
            {
                i++;
            }
            if(i >= length) break;
            //the moment it finds letter initialize j = i+1;
            int j = i+1;

            //iterate string till it have space
            while(j <length && Character.isLetter(input.charAt(j)))
            {
                j ++;
            }

            //cut the sub string from i , j and append to result
            String sub = input.substring(i, j);
            if(result.isEmpty()){
                result = sub;
            }
            else{
                //to make sure last word always append first
                result = sub + " " + result;
            }
            i = j+1;
        }
        return result;
    }
}
