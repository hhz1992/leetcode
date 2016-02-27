package binarysearch;

/**
 * Created by Huanzhou on 2016/2/13.
 */
public class No240_Searcha2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {

        int i=0, j=matrix[0].length-1;

        while(i>=0 && j<matrix.length){
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target)
                j++;
            else
                i--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{-1},{-1}};

        System.out.println(searchMatrix(matrix,-2));





    }

}
