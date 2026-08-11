class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i < ROW; i++) {
            for (int j=0; j < COL; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] row = q.poll();

            int r = row[0];
            int c = row[1];

            for (int[] dir : direction) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr > ROW - 1 || nc < 0 || nc > COL - 1 || grid[nr][nc] == -1
                    || grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[nr][nc] = grid[r][c]+1;

                q.offer(new int[] {nr ,nc});
            }
        }
    }
}
