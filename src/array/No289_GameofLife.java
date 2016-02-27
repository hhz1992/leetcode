package array;

/**
 * Created by Huanzhou on 2016/2/25.
 */
public class No289_GameofLife {
    public static void gameOfLife(int[][] board) {
        if(board == null || board[0].length<1)  return;

        int[][] result = new int[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int liveCount = 0;

                for(int v=-1;v<=1;v++){
                    for(int h=-1;h<=1;h++){
                        if(v==0 && h==0)
                            continue;
                        if(i+v>=0 && i+v<board.length && j+h>=0 && j+h<board[0].length){
                            if(board[i+v][j+h]==1)
                                liveCount++;
                        }
                    }
                }

                if(board[i][j]==1){
                    if(liveCount<2)
                        result[i][j] = 0;
                    else if(liveCount>=2 && liveCount<=3)
                        result[i][j] = 1;
                    else
                        result[i][j] = 0;
                }
                if(board[i][j]==0 && liveCount==3){
                    result[i][j] = 1;
                }

            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] = result[i][j];
            }
        }


    }

    public static void main(String[] args) {
        int[][] arr = {{1,1},{1,0}};

        gameOfLife(arr);
    }
}
