class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }
    public int quickSelect(int[] nums, int left, int right, int target){
        int pivot = nums[right];
        int p = left;
        for(int i=left;i<right;i++){
            if(nums[i]<=pivot){
                swap(nums,p,i);
                p++;
            }
        }
        swap(nums,p,right);
        if(p==target){
            return nums[p];
        }else if(p < target){
            return quickSelect(nums,p+1,right,target);
        }else{
            return quickSelect(nums,left,p-1,target);
        }
        
    }
    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
        return;
    }
}
