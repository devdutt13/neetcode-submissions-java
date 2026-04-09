class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> sol = new ArrayList();
        List<Integer> res = new ArrayList();
        Arrays.sort(nums);
        dfs(nums,0,sol,res);
        return sol;
    }
    public static void dfs(int[] nums, int index, List<List<Integer>> sol, List<Integer> res){
        if(index == nums.length){
            sol.add(new ArrayList(res));
            return;
        }
        res.add(nums[index]);
        dfs(nums,index+1,sol,res);
        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }
        res.remove(res.size()-1);
        dfs(nums,index+1, sol, res);
    }
}
