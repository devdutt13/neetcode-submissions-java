class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        dfs(nums, new boolean[nums.length], res, temp);
        return res;
    }
    public static void dfs(int[] nums, boolean[] pick, List<List<Integer>> res, List<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!pick[i]){
                pick[i]= true;
                temp.add(nums[i]);
                dfs(nums,pick,res,temp);
                temp.remove(temp.size()-1);
                pick[i] = false;

            }
        }
    }
}
