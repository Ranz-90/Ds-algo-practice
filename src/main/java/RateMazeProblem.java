import java.util.ArrayList;
import java.util.List;

public class RateMazeProblem {

    public static void main(String[] args){

        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        int N = maze.length;

        List<String> listOfPaths = solveMaze(maze,N);

        if(!listOfPaths.isEmpty()){
            for(String path : listOfPaths){
                System.out.println(path);
            }
        }
    }

    private static List<String> solveMaze(int[][] maze, int n) {
        List<String> paths = new ArrayList<>();
        //declare visted matrix to mark visited or not
        boolean[][] visited = new boolean[n][n];
        //Declare all four directions for x and y coordinates
        //Since we have to print paths in lexicographically order so we will follw D(down), L(left),R(right), U(up)
        //Down --> means if we i it will be i +1,j+0--> i+1,j
        //Left means for i it wil be i+0,j+(-1) --> i, j-1
        //right means for i i+0,j+1--> i,j+1

        //basically for each index we will add x and y coordinates and keep moving
        int[] dx = {1,0,0,-1};
        int[] dy = {0,-1,1,0};
        //if 1st cell is 1 then only we can strt otherwise not

        if(maze[0][0]==1)solve(0,0,n,"",paths,visited,dx, dy,maze);
        return paths;
    }

    private static void solve(int i, int j, int n,  String s, List<String> paths, boolean[][] visited,int[] dx, int[] dy,int[][] grid) {

        //Exit condition for recursion when we reach destination i.e n-1, n-1
        if(i == n-1 && j== n-1){
            paths.add(s);
            return;
        }
        //to maintain lexicographically order
        String direction = "DLRU";


        //for each cell iterate for all 4 directions
        for(int index =0; index < 4; index++){
             int nextI = i +dx[index];
             int nextJ = j + dy[index];

             //check all boundary conditions
            //i and j should be in range 0 to n
            //cell i.e. visited[nextRowCell][nextColumCell] should be false
            //and grid[nextRowCell][nextColumCell] should be 1 coz if its 0 we cant move
            //if all this condition satisfied we can move ahead

            if(nextI >=0 && nextI <n && nextJ >=0 && nextJ< n && !visited[nextI][nextJ] && grid[nextI][nextJ] ==1){

                //mark the cell as vistied
                visited[nextI][nextJ] =true;
                //call the recursion again
                solve(nextI,nextJ,n,s+Character.toString(direction.charAt(index)),paths,visited,dx,dy,grid);

                //backtracing once we come back from recursion make sure you make cell as unvisited again
                visited[nextI][nextJ] =false;
            }
        }
    }
}
