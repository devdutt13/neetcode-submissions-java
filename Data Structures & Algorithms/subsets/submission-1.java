class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol = new ArrayList();
        List<Integer> res = new ArrayList();
        backTrack(0,nums, res, sol);
        return sol;
    }
    public static void backTrack(int i, int[] nums, List<Integer> res, List<List<Integer>> sol){
        if(i == nums.length){
            sol.add(new ArrayList(res));
            return;
        }
        res.add(nums[i]);
        backTrack(i+1, nums, res, sol);
        res.remove(res.size()-1);
        backTrack(i+1,nums,res,sol);
    }
}
