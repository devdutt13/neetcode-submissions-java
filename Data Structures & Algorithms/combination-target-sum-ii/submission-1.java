class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> sol = new ArrayList();
       List<Integer> temp = new ArrayList();
       Arrays.sort(candidates);
       dfs(candidates, 0, target, 0, sol, temp);
       return sol; 
    }
    public static void dfs(int[] candidates,int index, int target, int total, List<List<Integer>> sol, List<Integer> temp){
        if (total == target){
            sol.add(new ArrayList(temp));
            return;
        }
        if(total > target || index == candidates.length){
            return;
        }
        temp.add(candidates[index]);
        dfs(candidates,index+1,target, total+candidates[index],sol,temp);
        temp.remove(temp.size()-1);
        while(index+1 < candidates.length && candidates[index+1] == candidates[index]){
            index++;
        }
        dfs(candidates, index+1, target, total, sol, temp);
    }
}
