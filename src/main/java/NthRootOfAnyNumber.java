import java.text.DecimalFormat;

public class NthRootOfAnyNumber {


    public static void main(String[] args){
        int n = 3;
        int m = 64;

       double outout = getNthRootOfAnyNumber(m,n);
        System.out.println(outout);

    }

    private static double getNthRootOfAnyNumber(int m, int n) {

        double low = 1;
        double high = m;
        double mid = 1.0;


        double diff = 1e-6;

        while(high-low > diff){

              mid = (high + low)/2.0;

            if(multiply(mid,n) < m){
                low = mid;
            }
            else{
                high = mid;
            }
        }

        return Double.valueOf(new DecimalFormat("0.00000").format(mid));

    }

    private static double multiply(double mid, int n) {

        double result = 1.0;
        for(int i =1; i <=n; i++){
            result = result*mid;
        }
        return result;


    }
}
