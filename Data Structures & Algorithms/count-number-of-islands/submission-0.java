class Solution {
    int ROW;
    int COL;
    boolean[][] vis;
    public int numIslands(char[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        vis = new boolean[ROW][COL];
        int island = 0;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    island++;
                    dfs(i, j, vis, grid);
                }
            }
        }

        return island;
    }

    public void dfs(int row, int col, boolean[][] vis, char[][] grid) {
        if (row < 0 || row > ROW - 1 || col < 0 || col > COL - 1 || vis[row][col]
            || grid[row][col] == '0') {
            return;
        }

        vis[row][col] = true;

        dfs(row - 1, col, vis, grid);
        dfs(row + 1, col, vis, grid);
        dfs(row, col - 1, vis, grid);
        dfs(row, col + 1, vis, grid);
    }
}
