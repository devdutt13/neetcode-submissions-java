class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>>();
        ArrayList<Integer> res = new ArrayList();
        dfs(nums,0,target,sol,res);
        return sol;
    }
    public static void dfs(int[] nums, int index, int target, List<List<Integer>> sol, List<Integer> res){
        if(target == 0){
            sol.add( new ArrayList<>(res));
            return;
        }
        if(target < 0 || index >= nums.length){
            return;
        }
        res.add(nums[index]);
        dfs(nums, index, target-nums[index], sol,res);
        res.remove(res.size()-1);
        dfs(nums,index + 1,target,sol, res);
        

    }
}
