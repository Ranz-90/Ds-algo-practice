package String;

public class MultiplyLargeNumberAsString {

    public static void main(String[] args)
    {
        String str1 = "1235421415454545454545454544";
        String str2 = "1714546546546545454544548544544545";

        if ((str1.charAt(0) == '-' || str2.charAt(0) == '-') &&
                (str1.charAt(0) != '-' || str2.charAt(0) != '-'))
            System.out.print("-");

        if (str1.charAt(0) == '-')
            str1 = str1.substring(1);

        if (str2.charAt(0) == '-')
            str2 = str2.substring(1);

        System.out.println(multiply(str1, str2));
    }

    private static String multiply(String str1, String str2) {

        String ouput = "";
        int len1= str1.length();
        int len2=str2.length();

       if(len1 == 0 || len2 == 0){
           return "0";
       }

        int[] result = new int[len1 + len2];
       int index1 =0;
       int index2 =0;

       for(int i= len1-1; i >= 0; i--){

           int carry =0;
            index2 =0;
           int n1 = str1.charAt(i) - '0';

           for(int j =len2-1; j >= 0; j--){

               int n2 = str2.charAt(j) - '0';

               int sum = n1 *n2 + result[index1+index2] + carry;

               carry = sum/10;
               result[index1+index2] = sum%10;

               index2++;
           }

           if(carry > 0){
               result[index1+index2] = result[index1+index2] + carry;
           }
           index1++;
       }

       int size = result.length-1;

       if(size >=0 && result[size] ==0)size--;

       while(size >=0){
           ouput += result[size--];
       }

        return ouput;
    }
}
