class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        if(str.length() == 0){
            return new ArrayList<>();
        }
        int i=0;
        List<String> res = new ArrayList<>();
        while(i<str.length()){
            int j=i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            i=j+1;
            j = i+len;
            res.add(str.substring(i,j));
            i=j;
        }
        return res;

    }
}
