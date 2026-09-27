class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i=0;i<nums.length; i++){
            if(curSum <0){
                curSum = 0;
            }
            curSum+=nums[i];
            maxSum = Math.max(curSum,maxSum);
        }
        return maxSum;
    }
}
