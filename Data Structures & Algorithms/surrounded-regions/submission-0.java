class Solution {
    public void solve(char[][] board) {
        capture(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
 
    }
    public void capture(char[][] board){
        Queue<int[]> q = new LinkedList<>();
        int ROW = board.length;
        int COL = board[0].length;
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL; j++){
                if(j == 0 && board[i][j] == 'O'){
                    board[i][j] = 'T';
                    q.offer(new int[]{i,j});
                } 
                if(j == COL-1 && board[i][j] == 'O'){
                    board[i][j] = 'T';
                    q.offer(new int[]{i,j});
                } 
                if(j == 0 && board[i][j] == 'O'){
                    board[i][j] = 'T';
                    q.offer(new int[]{i,j});
                } 
                if(i==0 && board[i][j] == 'O'){
                    board[i][j] = 'T';
                    q.offer(new int[]{i,j});
                } 
                if(i==ROW-1 && board[i][j] == 'O'){
                    board[i][j] = 'T';
                    q.offer(new int[]{i,j});
                } 

            }
        }
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] cor = q.poll();
            int r = cor[0];
            int c = cor[1];
            for(int[] d : dir){
                int nr = d[0] + r, nc = d[1] + c;
                if(nr>=0 && nc>=0 && nr<ROW && nc<COL && board[nr][nc] == 'O'){
                    board[nr][nc] = 'T';
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
