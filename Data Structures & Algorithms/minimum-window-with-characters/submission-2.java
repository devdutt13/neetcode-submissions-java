class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        char[] tCharCount = new char[128];
        char[] sCharCount = new char[128];
        for(char x : t.toCharArray()){
            tCharCount[x]++;
        }
        int start = 0;
        int matched =0;
        int left =0;
        int minLen = Integer.MAX_VALUE;
        for(int right =0; right<s.length();right++){
               sCharCount[s.charAt(right)]++;
               if(sCharCount[s.charAt(right)] <= tCharCount[s.charAt(right)]){
                matched++;
               }
               while(matched == t.length()){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }
                if(sCharCount[s.charAt(left)] <= tCharCount[s.charAt(left)]){
                    matched--;
                }
                sCharCount[s.charAt(left)]--;
                left++;
               }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}
