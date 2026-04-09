class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> sol = new ArrayList();
        if(digits.length()==0){
            return sol;
        }
       String[] digitCharDictionary = {"", "", "abc","def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
        backTrack(0,"",digits,digitCharDictionary,sol);
        return sol;
        
    }

    public static void backTrack(int index,String current, String digits, String[] digitCharDictionary, List<String> sol){
        if(digits.length() == current.length()){
            sol.add(current);
            return;
        }
        String ch = digitCharDictionary[digits.charAt(index) - '0'];
        for(char c : ch.toCharArray()){
            backTrack(index+1,current+c,digits,digitCharDictionary,sol);
        }


    }
}
