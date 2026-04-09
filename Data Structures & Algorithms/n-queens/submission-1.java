class Solution {
    public List<List<String>> solveNQueens(int n) {
        if(n == 0){
            return new ArrayList();
        }
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList();
        backTrack(0,board,res);
        return res;

    }
    public void backTrack(int r, char[][] board, List<List<String>> res){
        if(r == board.length){
            List<String> temp = new ArrayList();
            for(char[] row : board ){
                temp.add(new String(row));
            }
            res.add(temp);
            return;
        }

        for(int c=0;c<board.length;c++){
            if(isSafe(board,r,c)){
                board[r][c] = 'Q';
                backTrack(r+1,board,res);
                board[r][c] = '.';
            }
        }
    }
    public boolean isSafe(char [][] board, int r, int c){
        for(int i = r-1;i>=0;i--){
            if(board[i][c] == 'Q'){
                return false;
            }
        }
        for(int i = r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
         for(int i = r-1,j=c+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }




}
