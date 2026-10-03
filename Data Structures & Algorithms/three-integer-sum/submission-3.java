class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int l;
        int r;
        HashSet<List<Integer>> res = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            l=i+1;
            r = nums.length-1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum <0){
                    l++;
                }else if(sum > 0){
                    r--;
                }else{
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }
            
                
            }
  

        }
        return new ArrayList<>(res);


    }
}
