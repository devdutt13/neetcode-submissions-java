class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo,-1);
        return Math.min(dfs(cost,0), dfs(cost,1));       
    }
    public int dfs(int[] cost, int index){
        if(index >= cost.length){
            return 0;
        }
        if(memo[index] != -1){
            return memo[index];
        }
        memo[index] = cost[index] +Math.min(dfs(cost,index+1),dfs(cost,index+2));
        return memo[index];
    }

}
