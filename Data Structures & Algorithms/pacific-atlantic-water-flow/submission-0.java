class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> pac = new LinkedList<>();
        Queue<int[]> atl = new LinkedList<>();
        boolean[][] pac1 = new boolean[heights.length][heights[0].length];
        boolean[][] atl1 = new boolean[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            pac.offer(new int[]{i,0});
            atl.offer(new int[]{i,heights[0].length-1});
        }
        for(int i=0;i<heights[0].length;i++){
            pac.offer(new int[] {0,i});
            atl.offer(new int[] {heights.length-1,i});
        }
        bfs(pac,pac1,heights);
        bfs(atl,atl1,heights);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pac1[i][j] && atl1[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;

    }
    public void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights){
      int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
      while(!q.isEmpty()){
            int[] cor = q.poll();
            int r = cor[0];
            int c = cor[1];
            ocean[r][c] = true;
            for(int[] d : dir){
                int nr = r + d[0], nc = c + d[1];
                if(nr >= 0 && nc >= 0 && nr< heights.length && nc <heights[0].length && ocean[nr][nc] !=true && heights[nr][nc] >= heights[r][c]){
                    ocean[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }


      }
    }
}
