class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] memo = new int[s.length()+1];
        return dfs(0,s,memo);
    }
    public int dfs(int index, String s, int[] memo){
        if(s.length() == index){
            return 1;
        }
        if(s.charAt(index) == '0'){
            return 0;
        }
        if(memo[index] != 0){
            return memo[index];
        }
        int ways = dfs(index+1,s,memo);
        if(index+1 < s.length() && Integer.parseInt(s.substring(index,index+2)) <= 26){
            ways += dfs(index+2,s,memo);
        }
        return memo[index] = ways;
    }
}
