public class NoOFIlandsPob {

    public static void main(String[] args){

        int grid[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        int noOfIslands = getNoOfIlands(grid);

        System.out.println(noOfIslands);
    }

    private static int getNoOfIlands(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int count =0;

        boolean[][] visited = new boolean[row][col];

        for(int i =0; i < row;i++){
            for(int j =0; j <col; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    doDFS(i,j,grid,visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void doDFS(int row, int col, int[][] grid, boolean[][] visited) {

        visited[row][col] = true;

        int[] dx = {-1,1,-1,0,0,1,-1,1};
        int[] dy = {-1,0,0,1,-1,1,1,-1};

        for(int i =0; i < 8; i++){

            if(isSafe(row+dx[i],col+dy[i],grid,visited)){
                doDFS(row+dx[i],col+dy[i],grid,visited);
            }
        }

    }

    private static boolean isSafe(int row, int col, int[][] grid, boolean[][] visited) {

        return (0<= row && row < grid.length && 0<= col && col < grid[0].length && !visited[row][col] && grid[row][col] == 1);
    }
}
