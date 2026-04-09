class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        String[] s = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList();
        allComb(s,digits,new StringBuilder(""),res,0);

        return res;
    }
    public void allComb(String[] s, String digits, StringBuilder temp,List<String> res, int index){
        if(index == digits.length()){
            res.add(temp.toString());
            return;
        }
        char[] c = s[digits.charAt(index)-'0'].toCharArray();
        for(int i=0;i<c.length;i++){
            temp.append(c[i]);
            allComb(s,digits,temp,res,index+1);
             temp.deleteCharAt(temp.length()-1);
        }
        
    }
}
