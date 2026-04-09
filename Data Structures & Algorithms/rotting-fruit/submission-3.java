class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh =0;
        int minutes =0;
        int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[] {i,j});
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        while(!q.isEmpty()){
            
        int size = q.size();
        boolean isRotten = false;
        for(int i=0;i<size;i++){
            int[] cord = q.poll();
            int r = cord[0];
            int c = cord[1];
                for(int[] d : dir){
                int nr = r + d[0], nc = c + d[1];
                if(nr <0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] ==0){
                    continue;
                }
                if(grid[nr][nc] == 1){
                    isRotten = true;
                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[] {nr,nc});
                }
            }
        }
            
            if(isRotten){
                minutes++;
            }

        }
        return fresh == 0 ? minutes: -1;

    }
}
