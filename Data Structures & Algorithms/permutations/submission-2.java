class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        boolean[] p = new boolean[nums.length];
        Arrays.fill(p,false);
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums,p,res,new ArrayList<>());
        return res;
        
    }
    public void backTrack(int[] nums,boolean[] p, List<List<Integer>> res, List<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!p[i]){
                p[i] = true;
                temp.add(nums[i]);
                backTrack(nums,p,res,temp);
                temp.remove(temp.size()-1);
                p[i]=false;
            }
        }
    }
}
