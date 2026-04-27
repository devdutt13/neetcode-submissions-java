class Solution {
    public int characterReplacement(String s, int k) {
        char[] frequency = new char[26];
        int maxCount = 0;
        int l =0;
        int maxLen =0;
        for(int r=0;r<s.length();r++){
            frequency[s.charAt(r)-'A']++;
            maxCount=Math.max(maxCount,frequency[s.charAt(r)-'A']);
            while(r-l+1 - maxCount > k){
                frequency[s.charAt(l)-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
        
    }
}
