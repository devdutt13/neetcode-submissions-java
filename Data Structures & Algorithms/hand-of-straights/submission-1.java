class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize !=0){
            return false;
        }
        Arrays.sort(hand);
        Map<Integer,Integer> mp = new HashMap<>();
        for(int h : hand){
            mp.put(h,mp.getOrDefault(h,0)+1);
        }
        for(int card : hand){
            if(mp.get(card) == 0){
                continue;
            }
            for(int i = card; i<card+groupSize;i++){
                if(mp.getOrDefault(i,0) == 0){
                    return false;
                }
                mp.put(i,mp.get(i) -1);
            }
        }
        return true;

        
    }
}
