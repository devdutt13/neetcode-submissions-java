class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        dfs(digits,0,map,res,new StringBuilder(""));
        return res;
        }
        public void dfs(String digits, int index , String[] map, List<String> res, StringBuilder cur){
            if(index == digits.length()){
                res.add(cur.toString());
                return;
            }
            char[] c = map[digits.charAt(index) - '0'].toCharArray();
            for(char c1 : c){
                cur.append(c1);
                dfs(digits,index+1,map,res,cur);
                cur.deleteCharAt(cur.length()-1);
            }



        }
}

