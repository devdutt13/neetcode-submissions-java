class Solution {
    public boolean exist(char[][] board, String word) {
        int ROW = board.length;
        int COL = board[0].length;
        for(int i=0;i<ROW; i++){
            for(int j=0;j<COL;j++){
                if(dfs(i,j,board,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int i, int j, char[][] board, String word, int index){
        if(index == word.length()){
            return true;
        }
        if( i<0 || j<0 || i >= board.length || j>= board[0].length || board[i][j] != word.charAt(index) || board[i][j] == '#'){
            return false;
        }
        board[i][j] = '#';
        boolean res = dfs(i+1,j,board,word,index+1) || dfs(i-1,j,board,word,index+1) || dfs(i,j+1,board,word,index+1) || dfs(i,j-1,board,word,index+1);
        board[i][j] = word.charAt(index);
        return res;

    }
}
