class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int components = n;
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int pu = findParent(parent,u);
            int pv = findParent(parent,v);
            if(pu != pv){
                parent[pu] = pv;
                components--;
            }

        }
        return components;

        
    }
    public int findParent(int[] parent, int x){
        if(parent[x] == x){
            return x;
        }
        return findParent(parent,parent[x]);
    }
}
