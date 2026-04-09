class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left] + nums[right] == target){
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }
            if(nums[left] + nums[right] > target){
                right--;
            }
            if(nums[left] + nums[right] < target){
                left++;
            }
        }
        return res;
        
    }
}
