class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res =0;
        HashSet<Character> h = new HashSet();
        int l =0;
        for(int r = 0; r<s.length(); r++){
            while(h.contains(s.charAt(r))){
                h.remove(s.charAt(l));
                l++;
            }
            h.add(s.charAt(r));
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
