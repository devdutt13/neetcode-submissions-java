class Solution {
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length()){
            return false;
        }
        int[] sMap = new int[26];
        int[] tMap = new int[26];
        for(int i=0;i<s.length();i++){
            sMap[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            tMap[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(sMap[i] != tMap[i]){
                return false;
            }
        }
        return true;
    }
}
