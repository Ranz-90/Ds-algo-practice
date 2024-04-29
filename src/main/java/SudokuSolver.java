public class SudokuSolver {

    public static void main(String[] args){
        int board[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if(solve(board)){
            printBoard(board);
        }
        else{
            System.out.println("No Solution exist");
        }
    }

    private static boolean solve(int[][] board) {

        for(int i=0; i <board.length; i++){
            for(int j = 0; j <board[0].length; j++){

                if(board[i][j] == 0){

                    for(int k=1; k <=9; k++){
                        if(isValid(board,i,j,k)){
                          board[i][j] =k;

                          if(solve(board)){
                              return true;
                          }
                          else{
                              board[i][j] = 0;
                          }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {

        for(int i =0;i < 9; i++){
            if(board[i][col] == num){
                return false;
            }
            if(board[row][i] == num){
                return false;
            }
            if(board[3*(row/3) + i/3][3*(col/3)+i%3] == num){
                return false;
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {

        for(int i =0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
