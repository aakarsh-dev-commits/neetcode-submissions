class Solution {

    int ROW;
    int COL;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROW = heights.length;
        COL = heights[0].length;

        boolean[][] pacific = new boolean[ROW][COL];
        boolean[][] atlantic = new boolean[ROW][COL];

        Queue<int[]> qPacific = new LinkedList<>();
        Queue<int[]> qAtlantic = new LinkedList<>();

        List<List<Integer>> ls = new ArrayList<>();

        for(int i = 0 ; i < COL ; i++) {
            pacific[0][i] = true;
            qPacific.offer(new int[] {0,i});
        }

        for(int i = 0 ; i < ROW; i++) {
            pacific[i][0] = true;
            qPacific.offer(new int[] {i,0});
        }

        for(int i = 0 ; i < ROW ; i++) {
            atlantic[i][COL-1] = true;
            qAtlantic.offer(new int[] {i,COL-1});
        }

        for(int i = 0 ; i < COL ; i++) {
            atlantic[ROW-1][i] = true;
            qAtlantic.offer(new int[] {ROW-1,i});
        }

        bfs(qPacific,pacific,heights);
        bfs(qAtlantic,atlantic,heights);


        for(int i = 0 ; i < ROW ; i++) {
            for(int j = 0 ; j < COL ; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    ls.add(List.of(i,j));
                }
            }
        }


        return ls;


    }


    public void bfs(Queue<int[]> q ,boolean[][] vis , int[][] heights  ) {
        while(!q.isEmpty()) {
            int[] cord = q.poll();

            int r = cord[0];
            int c = cord[1];

            int[][] direction = {{0,1} , {0,-1} , {1,0} , {-1,0}};

            for(int[] dir : direction ) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nr > ROW-1 || nc <0 || nc > COL-1) {
                    continue;
                }

                if(vis[nr][nc]) {
                    continue;
                }

                if(heights[nr][nc] < heights[r][c]) {
                    continue;
                }

                vis[nr][nc] = true;
                q.offer(new int[] {nr,nc});
            }
        }
    }
}
