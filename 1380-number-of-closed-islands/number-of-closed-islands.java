class Solution {

    int n;
    int m;
    int vis[][];
    int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    boolean bfs(int row, int col, int grid[][]) {

        vis[row][col] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        boolean flag = true;

        while (!q.isEmpty()) {

            int curr[] = q.poll();

            if (curr[0] == 0 || curr[0] == n - 1 || curr[1] == 0 || curr[1] == m - 1) {

                flag = false;
            }

            for (int dir[] : dirs) {

                int new_row = curr[0] + dir[0], new_col = curr[1] + dir[1];

                if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < m && vis[new_row][new_col] == 0 && grid[new_row][new_col] == 0) {

                    vis[new_row][new_col] = 1;
                    q.offer(new int[]{new_row, new_col});
                }
            }
        }

        return flag;
    }

    public int closedIsland(int[][] grid) {

        n = grid.length;
        m = grid[0].length;
        vis = new int[n][m];

        int ans = 0;

        for (int i=0; i<n; i++) {

            for (int j=0; j<m; j++) {

                if (vis[i][j] == 0 && grid[i][j] == 0 && bfs(i, j, grid)) {

                    ans++;
                }
            }
        }

        return ans;
    }
}