class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord) || !wordList.contains(endWord)){
            return 0;
        }
        Set<String> words = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int res =0;
        q.offer(beginWord);
        while(!q.isEmpty()){
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++){
                
               String newWord = q.poll();
               if(newWord.equals(endWord)){
                return res;
               }
               for(int j=0;j<newWord.length();j++){
                for(char c ='a'; c<='z';c++){
                    if(c == newWord.charAt(j)){
                        continue;
                    }
                    String nei = newWord.substring(0,j) + c + newWord.substring(j+1);
                    if(words.contains(nei)){
                        q.offer(nei);
                        words.remove(nei);
                    }

                }
               }


            }

        }
        return 0;
    }
}
