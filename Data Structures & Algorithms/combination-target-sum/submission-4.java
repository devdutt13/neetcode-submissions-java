class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if(nums.length == 0 || target == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, target, res, new ArrayList<>());
        return res;
        
    }
    public void backTrack(int[] nums, int index, int target, List<List<Integer>> res, List<Integer> temp){
        if(target == 0){
            res.add(new ArrayList(temp));
            return;
        }
        if(target < 0 || index == nums.length){
            return;
        }
        temp.add(nums[index]);
        backTrack(nums,index,target-nums[index],res,temp);
        temp.remove(temp.size()-1);
        backTrack(nums,index+1,target,res,temp);



        
    }
}
