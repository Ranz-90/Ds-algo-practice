package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {

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

        int days = 0;
        int m = row;
        int n = col;
        int totalOranges = 0;
        int rottenCount = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();
        for(int i =0; i <m; i ++){
            for(int j =0; j <n; j++){
                //Count total no of oranges
             if(grid[i][j] != 0)   totalOranges++;

             //If rooten orange found , push the i, j (cell index) to queue as pair
             if(grid[i][j] == 2) rottenQueue.add(new int[]{i,j});
            }
        }

        //x(horizontal), y (vertical) coordinates for a given index for right, left, bottom , up
        int dx[] = {0,0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        if (totalOranges == 0) return 0;

        //Iterate the queue till its empty and take rotten cell index one by one.
        while(!rottenQueue.isEmpty()){
            //Size of queue and no of rotten so far;
            int size = rottenQueue.size();
            rottenCount = rottenCount + size;

            //Iterate each cell index of rotten cell
            for(int i =0; i <size ; i ++ ){
                //get
                int[] point = rottenQueue.poll();
                //now for each cel index of rotten cell it
                // //can have 4 possible adjacent cell(L, R, U, D) which it can make as rotten
                for(int j =0; j <4; j ++){
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    //Check boundary condition x is not less zero and greter than row size
                    ///Check boundary condition y  is not less zero and greter than col size
                    //grid[x][y] == 0 means empty cell
                    //grid[x][y] == 2 means cell has already rotten

                    if(x <0 || y <0 || x >=row || y >= col || grid[x][y] ==0 || grid[x][y] == 2) continue;

                    //if all these above 4  condition not satisfied , means it can eligible to rotten the cell and
                    //so we can make this to 2 and marked as rotten

                        grid[x][y] = 2;
                    //Once we marked the cell as rotten
                    ////Once we iterated the queue and put the index of next rotten cell

                    rottenQueue.offer(new int[]{x, y});
                }
            }

            if(rottenQueue.size() > 0){
                days++;
            }
        }

        //Finally once we are out of while loop that mean queue iteration is done
        //if total no of oranges is equals to rotten orange simply return the days;
        //Otherwise retun -1 i.e not possible
        if(totalOranges == rottenCount){
            return days;
        }
        else{
            return -1;
        }
    }

}
