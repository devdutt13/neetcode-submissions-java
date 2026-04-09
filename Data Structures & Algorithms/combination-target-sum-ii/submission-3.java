class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList();
        List<Integer> res = new ArrayList();
        Arrays.sort(candidates);
        backTrack(candidates,target,0,sol,res);
        return sol;
    }
    public static void backTrack(int[] candidates, int target, int i, List<List<Integer>> sol, List<Integer> res){
        if(target == 0){
            sol.add(new ArrayList(res));
            return;
        }
        if(target < 0 || i>= candidates.length){
            return;
        }
        res.add(candidates[i]);
        backTrack(candidates,target-candidates[i],i+1,sol,res);
        res.remove(res.size()-1);
        while(i+1 < candidates.length && candidates[i+1] == candidates[i]){
            i++;
        }
        backTrack(candidates,target, i+1, sol,res);

    }
}
