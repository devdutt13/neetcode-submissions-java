class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 ){
            return 0;
        }
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]<= nums[r]){
                if(target < nums[mid] || nums[r] <target){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(target < nums[l] || target > nums[mid]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }

        }
        return -1;
        
    }
}
