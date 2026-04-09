

class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        // Push all treasures (0) as BFS sources
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) q.offer(new int[]{r, c});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;
                if (grid[nr][nc] != INF) continue; // wall(-1), treasure(0), or already filled

                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}
