class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int[] countT = new int[128];
        int minLen = Integer.MAX_VALUE;
        int[] window = new int[128];
        int left =0;
        int matched = 0;
        int start =0;
        for(char c : t.toCharArray()){
            countT[c]++;
        }
        for(int right = 0; right<s.length();right++){
            char rightChar = s.charAt(right);
            window[rightChar]++;
            if(window[rightChar] <= countT[rightChar]){
                matched++;
            }
            while(matched == t.length()){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }
                char remove = s.charAt(left);
                if(window[remove] <= countT[remove]){
                    matched--;
                }
                window[remove]--;
                left++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}
