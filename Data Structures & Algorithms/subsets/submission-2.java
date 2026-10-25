class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length ==0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums,0,res,new ArrayList<>());
        return res;
        
    }
    public void backTrack(int[] nums, int index, List<List<Integer>> res, List<Integer> temp){
        if(index == nums.length){
            res.add(new ArrayList(temp));
            return;
        }
        temp.add(nums[index]);
        backTrack(nums,index+1,res,temp);
        temp.remove(temp.size()-1);
        backTrack(nums,index+1,res,temp);
    }
}
