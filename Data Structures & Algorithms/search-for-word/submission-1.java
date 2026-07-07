class Solution {
    int ROW, COL;
    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;
        boolean[][] vis = new boolean[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(dfs(i,j,0,word,board,vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int row, int col, int index, String word, char[][] board, boolean[][] vis) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= ROW || col < 0 || col >= COL || vis[row][col]
            || board[row][col] != word.charAt(index)) {
            return false;
        }

        vis[row][col] = true;
        boolean res = (dfs(row + 1, col, index + 1, word, board, vis)
            || dfs(row - 1, col, index + 1, word, board, vis)
            || dfs(row, col + 1, index + 1, word, board, vis)
            || dfs(row, col - 1, index + 1, word, board, vis));

        vis[row][col] = false;

        return res;
    }
}
