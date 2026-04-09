class Solution {
    public List<List<String>> solveNQueens(int n) {
       char[][] board = new char[n][n];
       List<List<String>> sol = new ArrayList();
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            board[i][j] = '.';
        }
       }
       backTrack(0,board,sol); 
       return sol;
    }
    public static void backTrack(int r , char[][] board, List<List<String>> sol){
        if(r == board.length){
            List<String> temp = new ArrayList();
            for(char[] row : board){
                temp.add(new String(row));
            }
            sol.add(temp);
            return;
        }
        for(int c = 0; c< board.length;c++){
            if(isSafe(r,c,board)){
                board[r][c]='Q';
                backTrack(r+1,board,sol);
                board[r][c] = '.';
            }
        }
    }
    public static boolean isSafe(int r, int c , char[][] board){
        for(int i=r-1;i>=0;i--){
            if(board[i][c]=='Q'){
                return false;
            }
        }
        for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=r-1, j=c+1; i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
