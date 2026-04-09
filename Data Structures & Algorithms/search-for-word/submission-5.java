class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0 || board[0].length == 0){
            return false;
        }
        if(word.length() == 1 && board[0][0]==word.charAt(0)){
            return true;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,0,i,j)){
                    return true;
                }

            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int index, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if(index == word.length()){
            return true;
        }
        if(board[i][j] == word.charAt(index)){
            char temp = board[i][j];
            board[i][j] = '#';
            boolean res = dfs(board,word,index+1,i-1,j) || dfs(board,word,index+1,i+1,j) || dfs(board,word,index+1,i,j-1) || dfs(board,word,index+1,i,j+1); 
            board[i][j] = temp;
            return res;
        }
        return false;
    }
   
}
