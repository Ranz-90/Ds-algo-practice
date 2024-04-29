import java.util.LinkedList;
import java.util.Queue;

public class RottenChangePractice2 {


    public static void main(String[] args){

        int row = 10;
        int col = 10;
        int[][] grid = new int[row][col];

        //Cell with value 0 denotes - Empty cell i.e. No Orange
        //Cell with value 1 denotes -Fresh Orange
        //Cell with value 2 denotes - Rotten Orange

        //Rotten orange in any index i,j can make rotten the oranges in all four possible (left,right,up, down)

        int minutes = getMinimumMinutes(grid,row, col);

    }

    private static int getMinimumMinutes(int[][] grid, int row, int col) {

        Queue<int[]> queue = new LinkedList<>();
        int days = 0;
        int m = row;
        int n = col;
        int totalOranges = 0;
        int rottenCount = 0;

        for(int i=0; i <m; i++){
            for(int j=0; j <n; j++){
                if(grid[i][j] == 1) totalOranges++;
                if(grid[i][j] == 2) queue.offer(new int[]{i,j});
            }
        }

        if(totalOranges == 0)return 0;

        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};

       while(!queue.isEmpty()){

           rottenCount = rottenCount + queue.size();

           for(int i =0; i <queue.size(); i++){

               int[] cell = queue.peek();

               for(int j=0; j < 4; j++){
                   int x = cell[0] + dx[0];
                   int y = cell[1] + dy[0];

                   if(x <0 || y<0 || x >= row || y >= col || grid[x][y] == 0 || grid[x][y] == 2) continue;
                   else{
                       grid[x][y] = 2;
                       queue.offer(new int[]{x,y});
                   }
               }
           }

           if(queue.size() > 0) days++;
       }

       if(totalOranges == rottenCount)return days;
       else return -1;

    }
}
