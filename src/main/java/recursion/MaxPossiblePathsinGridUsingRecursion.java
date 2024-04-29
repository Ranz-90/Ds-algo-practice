package recursion;

public class MaxPossiblePathsinGridUsingRecursion {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int output = getMaxPossiblePathsInGrid(m, n);
        System.out.println("Max no of Possible paths is " + output);
    }

    private static int getMaxPossiblePathsInGrid(int m, int n) {
        //exit condition
        if (m == 1 || n == 1) {
            return 1;
        } else {
            return getMaxPossiblePathsInGrid(m - 1, n) + getMaxPossiblePathsInGrid(m, n - 1);
        }

    }
}
