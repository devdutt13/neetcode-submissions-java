class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList();
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        dfs(nums,0,temp,sol);
        return sol;
    }
    public static void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> sol){
        if( index == nums.length){
            sol.add( new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        dfs(nums, index+1,temp,sol);
        temp.remove(temp.size()-1);
        dfs(nums, index+1, temp, sol);
    }
}
