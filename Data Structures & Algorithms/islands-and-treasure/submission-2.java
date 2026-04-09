class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    q.offer(new int[] {i,j});
                }
            }
        }
        while(!q.isEmpty()){
          int[] cor = q.poll();
          int r = cor[0];
          int c = cor[1];
          for(int[] dir : d){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr < 0 || nc<0 || nr >= grid.length || nc >= grid[0].length){
                continue;
            }
            if(grid[nr][nc] != Integer.MAX_VALUE){
                continue;
            }
            grid[nr][nc] = grid[r][c] +1;
            q.offer(new int[]{nr,nc});
          }

        }
    }
}
