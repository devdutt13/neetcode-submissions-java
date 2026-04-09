class Solution {
    public List<String> generateParenthesis(int n) {
       if(n==0){
        return new ArrayList<>();
       } 
       List<String> res = new ArrayList<>();
       
       sol(0,0,new StringBuilder(),n,res);
       return res;
    }
    public void sol(int open, int closed, StringBuilder temp,int n, List<String> res){
        if(closed == open && open == n){
            res.add(temp.toString());

        }
        if(open < n){
            temp.append("(");
            sol(open+1,closed,temp,n,res);
            temp.deleteCharAt(temp.length()-1);
        }
        if(closed < open){
            temp.append(")");
            sol(open,closed+1,temp,n,res);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    
}
