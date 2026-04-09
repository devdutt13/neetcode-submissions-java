class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> currentList = new ArrayList<>();
        for(int stone : stones){
            currentList.add(stone);
        }
         while(currentList.size() > 1){
            Collections.sort(currentList);
            int dif = currentList.remove(currentList.size()-1) -  currentList.remove(currentList.size()-1);
            if(dif != 0){
                currentList.add(dif);
            }
         }
         return currentList.isEmpty() ? 0 : currentList.get(0);
    }
}
