class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        int l = 0;
        int right = nums.length-1;
        while(l<right){
            int mid = l + (right-l)/2;
            if(nums[right] < nums[mid]){
                l = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[l];
        
        
    }
}
