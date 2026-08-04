class Solution {
    int ROW, COL;
    public boolean exist(char[][] board, String word) {
        ROW = board.length ;
        COL = board[0].length;
        boolean[][] vis = new boolean[ROW][COL];
        for (int i=0; i < ROW; i++) {
            for (int j=0; j < COL; j++) {
                if (dfs(0,i,j,word,vis,board)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int index, int row, int col, String word, boolean[][] vis, char[][] board) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= ROW || col < 0 || col >= COL || vis[row][col]
            || board[row][col] != word.charAt(index)) {
            return false;
        }

        vis[row][col] = true;

        boolean res = (dfs(index + 1, row + 1, col, word, vis, board)
            || dfs(index + 1, row - 1, col, word, vis, board)
            || dfs(index + 1, row, col + 1, word, vis, board)
            || dfs(index + 1, row, col - 1, word, vis, board));

        vis[row][col] = false;

        return res;    
    }
}
