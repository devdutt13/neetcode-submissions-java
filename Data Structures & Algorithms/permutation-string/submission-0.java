class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1A = new int[26];
        int l=0;
        for(int i=0;i<s1.length();i++){
            s1A[s1.charAt(i)-'a']++;
        }
        int[] window = new int[26];
        for(int r=0;r<s2.length();r++){
            window[s2.charAt(r)-'a']++;
            while(r-l+1 > s1.length()){
                window[s2.charAt(l)-'a']--;
                l++;
            }
            if(Arrays.equals(window,s1A)){
                return true;
            }
        }



        return false;
    }
}
