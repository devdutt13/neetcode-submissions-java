class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap();
        List<List<Integer>> freq = new ArrayList<>();
        for(int i=0;i<=nums.length;i++){
            freq.add(new ArrayList<>());
        }
        for(int num : nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            freq.get(entry.getValue()).add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i= freq.size()-1;i>=0;i--){
            for(int n : freq.get(i)){
                res[index++] = n;
                if(index == k){
                    return res;
                }
            }
        }
        return new int[0];
    }
}
