class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            int px = findParent(parent,x);
            int py = findParent(parent,y);
            if(px == py){
                return false;
            }
            parent[px] = py;
        }
        return true;


    }
    public int findParent(int[] parent, int x){
        if(parent[x] == x){
            return x;
        }
        return findParent(parent,parent[x]);
    }
}
