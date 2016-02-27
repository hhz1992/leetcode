package search;

/**
 * Created by Huanzhou on 2016/2/20.
 */
public class No200_NumberofIslands {
    public static int numIslands(char[][] grid) {
        int result = 0;
        if(grid==null || grid.length == 0 || grid[0].length==0)
            return 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    result++;
                }
            }
        }
        return result;
    }

    public static void dfs(char[][] grid,int row, int col) {

        if (grid[row][col] == '1') {
            grid[row][col] = '3';

            if (row - 1 >= 0)
                dfs(grid, row - 1, col);
            if (row + 1 < grid.length)
                dfs(grid, row + 1, col);
            if (col - 1 >= 0)
                dfs(grid, row, col - 1);
            if (col + 1 < grid[0].length)
                dfs(grid, row, col + 1);
            return;
        } else return;

    }

    public static void main(String[] args) {

        char[][] grid = {{'1','0'}};

        System.out.println(numIslands(grid));


    }
}
