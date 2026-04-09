class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> sol = new ArrayList();
        List<Integer> res = new ArrayList();
        backTrack(nums,0, target,sol,res);
        return sol;
    }
    public static void backTrack(int[] nums,int i, int target, List<List<Integer>> sol, List<Integer> res){
        if(target == 0){
            sol.add(new ArrayList(res));
            return;
        }
        if(target < 0 || i >= nums.length ){
            return;
        }
        res.add(nums[i]);
        backTrack(nums,i,target-nums[i],sol,res);
        res.remove(res.size()-1);
        backTrack(nums,i+1,target,sol,res);

    }
}
