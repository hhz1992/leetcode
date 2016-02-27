package amazonOA;

/**
 * Created by Huanzhou on 2016/2/13.
 */
public class Search2DMatrix {

    public  int searchMatrix(int[][] matrix, int target) {

        if(matrix.length==0 || matrix==null)
            return 0;
        if(matrix[0].length==0 || matrix[0]==null)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int x = n-1;
        int y =0;
        int count = 0;
        while(x>=0 && y<m){
            if(matrix[x][y]<target)
                y++;
            else if(matrix[x][y]>target)
                x--;
            else{
                x--;
                y++;
                count++;
            }
        }
        return count;
    }

}
