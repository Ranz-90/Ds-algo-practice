import java.util.ArrayList;
import java.util.List;

public class PrintMatrixInSpiralForm {

    public static void main(String[] args){

        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        System.out.println(spiralOrder(a));
    }

    private static List<Integer> spiralOrder(int[][] grid) {

        List<Integer> spiralList = new ArrayList<>();

        int row = grid.length;
        int col = grid[0].length;
        int di = 0;
        int r =0;
        int c = 0;

        boolean[][] visited = new boolean[row][col];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for(int i =0; i < row*col; i++){

            spiralList.add(grid[r][c]);
            visited[r][c] = true;
            int rr = r + dx[di];
            int cc = c+ dy[di];


            if(0 <= rr && rr <row && 0<=cc && cc < col && !visited[rr][cc]){
               r = rr;
               c = cc;
            }
            else{
                di = (di+1)%4;
                r += dx[di];
                c += dy[di];
            }
        }

        return spiralList;
    }
}
