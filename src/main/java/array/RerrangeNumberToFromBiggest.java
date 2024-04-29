package array;

import java.util.*;

public class RerrangeNumberToFromBiggest {

    public static void main(String[] args){
        List<String> listOfNumber = new ArrayList<>();
        listOfNumber.add("54");
        listOfNumber.add("546");
        listOfNumber.add("548");
        listOfNumber.add("60");

        printLargest(listOfNumber);



        for(String s : listOfNumber){
            System.out.print(s);
        }
    }

    private static void printLargest(List<String> listOfNumber) {


        Collections.sort(listOfNumber, new Comparator<String>() {
            @Override
            public int compare(String X, String Y) {
                String XY = X+Y;
                String YX = Y+X;
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

    }


}
