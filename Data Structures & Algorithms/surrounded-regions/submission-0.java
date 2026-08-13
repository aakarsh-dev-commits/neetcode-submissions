class Solution {
    int ROW;
    int COL;
    public void solve(char[][] board) {
        ROW = board.length;
        COL = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] vis = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (i == 0 || j == 0 || i == ROW - 1 || j == COL - 1) {
                    if (board[i][j] == 'O') {
                        vis[i][j] = true;
                        q.offer(new int[] {i, j});
                    }
                }
            }
        }

        bfs(q,vis,board);



        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }



    }

    public void bfs(Queue<int[]> q, boolean[][] vis, char[][] board) {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {

            int[] cord = q.poll();
            int r = cord[0];
            int c = cord[1];

            for(int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nr > ROW-1 || nc < 0 || nc > COL-1 || board[nr][nc] == 'X' || vis[nr][nc]) {
                    continue;
                }

                if(board[nr][nc] == 'O') {
                    vis[nr][nc] = true;
                    q.offer(new int[] {nr,nc});
                    continue;
                }
            }
        }
        
        
    }
}
