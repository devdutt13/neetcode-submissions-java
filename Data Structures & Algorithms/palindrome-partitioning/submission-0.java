class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> sol = new ArrayList();
        List<String> res = new ArrayList();
        dfs(s,0,sol,res);
        return sol;
    }
    public static void dfs(String s, int i, List<List<String>> sol, List<String> res){
        if(i >= s.length()){
            sol.add(new ArrayList(res));
        }
        for(int j=i;j<s.length();j++){
            if(isPal(s,i,j)){
                res.add(s.substring(i,j+1));
                dfs(s,j+1,sol,res);
                res.remove(res.size()-1);
            }
        }
    }
    public static boolean isPal(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
