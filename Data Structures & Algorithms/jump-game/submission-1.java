class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0){
            return true;
        }
        int goal = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] + i >= goal){
                goal = i;
            }
        }
        return goal==0;
    }
}
