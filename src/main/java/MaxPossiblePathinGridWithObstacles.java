public class MaxPossiblePathinGridWithObstacles {

/*    Given a grid of size m * n, let us assume you are starting at (1, 1)
    and your goal is to reach (m, n). At any instance, if you are on (x, y),
    you can either go to (x, y + 1) or (x + 1, y).
    Now consider if some obstacles are added to the grids. How many unique paths would there be?
    An obstacle and empty space are marked as 1 and 0 respectively in the grid.

    Input: [[0, 0, 0],
            [0, 1, 0],
            [0, 0, 0]]
    Output : 2
    There is only one obstacle in the middle.*/

    public static void main(String[] args)
    {
        int[][] A
                = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

        System.out.print(uniquePathsWithObstacles(A));
    }

    private static int uniquePathsWithObstacles(int[][] a) {

        int row = a.length;
        int col = a[0].length;

        // If obstacle is at starting position, no ways hence return 0;
        if(a[0][0] != 0 ) return 0;

        int[][] dp = new int[row][col];


        // first row all are '1' until obstacle
        for(int i=0;i <col;i++){
            if(a[0][i] == 0){
                dp[0][i] = 1;
            }
            else{
                dp[0][i] = 0;
            }
        }

        // first col all are '1' until obstacle

        for(int j=0; j <row; j ++){
            if(a[j][0] == 0){
                dp[j][0] = 1;
            }
            else{
                dp[j][0] = 0;
            }
        }

        for(int i =1; i <row; i++){
            for(int j=1; j < col; j++){
                if(a[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        return dp[row-1][col-1];
    }
}
