class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if(target ==0 || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(nums, target,0,temp,res);

        return res;

    }
    public void backTrack(int[] nums, int target, int index,List<Integer> temp, List<List<Integer>> res){
        if(target == 0){
           res.add(new ArrayList(temp));
           return;
        }
        if(target < 0 || index>=nums.length){
            return;
        }
        temp.add(nums[index]);
        backTrack(nums,target-nums[index],index,temp,res);
        temp.remove(temp.size()-1);
        backTrack(nums,target,index+1,temp,res);
    }
}
