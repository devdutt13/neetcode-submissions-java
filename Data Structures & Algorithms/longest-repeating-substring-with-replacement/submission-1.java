class Solution {
    public int characterReplacement(String s, int k) {
        char[] frequency = new char[26];
        int l =0,res=0;
        int maxCount =0;
        for(int r=0;r<s.length();r++){
            frequency[s.charAt(r)-'A']++;
            maxCount = Math.max(maxCount,frequency[s.charAt(r)-'A']);
            while(r-l+1 - maxCount > k){
                frequency[s.charAt(l)-'A']--;
                l++;
            }
            res = Math.max(r-l+1,res);
            
        }
        return res;
    }
}
