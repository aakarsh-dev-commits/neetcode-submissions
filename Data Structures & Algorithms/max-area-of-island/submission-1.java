class Solution {
    int ROW;
    int COL;
    boolean[][] vis;
    int maxArea;
    int area;
    public int maxAreaOfIsland(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        maxArea = 0;
        area = 0;
        vis = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    dfs(i, j, grid, vis);
                    area = 0;
                }
            }
        }

        return maxArea;
    }

    public void dfs(int row, int col, int[][] grid, boolean[][] vis) {
        if (row < 0 || row > ROW - 1 || col < 0 || col > COL - 1 || grid[row][col] == 0
            || vis[row][col]) {
            return;
        }

        vis[row][col] = true;
        area++;
        maxArea = Math.max(area, maxArea);

        dfs(row - 1, col, grid, vis);
        dfs(row + 1, col, grid, vis);
        dfs(row, col - 1, grid, vis);
        dfs(row, col + 1, grid, vis);
    }
}
