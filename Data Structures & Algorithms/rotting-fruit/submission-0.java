class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int fresh = 0;
        int minutes = 0;
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
        if (fresh == 0){
            return 0;
        }
        while(!q.isEmpty()){
            boolean isRotten = false;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] coord = q.poll();
                int r = coord[0];
                int c = coord[1];
                for(int[] d : dir){
                    if(r + d[0] >= 0 && c + d[1] >= 0 && r + d[0] < grid.length && c + d[1] < grid[0].length && grid[r+d[0]][c+d[1]] == 1){
                          grid[r+d[0]][c+d[1]] = 2;
                          fresh --;
                          isRotten = true;
                          q.offer(new int[] {r+d[0],c+d[1]});

                    }
                }
            }
            if(isRotten){
                minutes++;
            }
        }
        return fresh == 0 ? minutes : -1;


    }
}
