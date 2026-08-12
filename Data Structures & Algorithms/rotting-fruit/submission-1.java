class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] cord = q.poll();

                int r = cord[0];
                int c = cord[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr > ROW - 1 || nc < 0 || nc > COL - 1 || grid[nr][nc] == 0
                        || grid[nr][nc] == 2) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    q.offer(new int[] {nr, nc});
                    rotted = true;
                }
            }
            if (rotted) {
                time++;
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}
