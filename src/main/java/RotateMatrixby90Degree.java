public class RotateMatrixby90Degree {

    public static void main(String[] args){

        int row = 2;
        int col = 3;
        int[][] input = new int[row][col];

        doRotateteMatrix(input, row, col);
    }

    private static void doRotateteMatrix(int[][] input, int row, int col) {

        //1st step transpose matrix
        //Transpose means colum will be row

        //To transpose simply swap row colum index i.e i, j with j,i
        for(int i =0; i < row; i++){
            for(int j =0; j < input[0].length; j ++){
                int temp =0;
                 temp = input[i][j];
                input[i][j] = input[j][i];
                input[j][i] = temp;
            }
        }

        //Once transposed then simply reverse rwo wise value
        //Reversed using two pointer approach
        //basically col 0 will be replaved with n(n is total no of col), col 1 with n-1 so on

        for(int i = 0; i <row; i ++){
            for(int j =0; j < input[0].length/2; j++){
int temp =0;
                 temp = input[i][j];
                input[i][j] = input[i][input.length-1-j];
                input[i][input.length-1-j] = temp;

            }
        }
    }
}
