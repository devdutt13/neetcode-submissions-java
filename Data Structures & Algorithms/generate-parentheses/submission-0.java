class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int open = 0;
        int closed = 0;
        StringBuilder temp = new StringBuilder("");
        backTrack(n,0,0,temp,res);
        return res;
    }
    public void backTrack(int n, int open, int closed,StringBuilder temp, List<String> res){
        if(open == closed && open == n){
            res.add(temp.toString());
            return;
        }
        if(open < n){
            temp.append("(");
            backTrack(n,open+1,closed,temp, res);
            temp.deleteCharAt(temp.length()-1);
        }
        if(closed < open){
            temp.append(")");
            backTrack(n,open,closed+1,temp, res);
            temp.deleteCharAt(temp.length()-1);
        }


    }
}
