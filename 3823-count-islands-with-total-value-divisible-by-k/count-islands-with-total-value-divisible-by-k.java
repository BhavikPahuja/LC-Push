class Solution {

    int n;
    int m;
    int vis[][];
    int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    long bfs(int row, int col, int a[][]) {

        long sum = 0;
        vis[row][col] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        while (!q.isEmpty()) {

            int curr[] = q.poll();
            int r = curr[0], c = curr[1];

            sum += a[r][c];

            for (int dir[] : dirs) {

                int nr = r + dir[0], nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && a[nr][nc] != 0) {

                    vis[nr][nc] = 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return sum;
    }

    public int countIslands(int[][] grid, int k) {

        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        vis = new int[n][m];

        for (int i=0; i<n; i++) {

            for (int j=0; j<m; j++) {

                if (vis[i][j] == 0 && grid[i][j] != 0) {

                    long curr = bfs(i, j, grid);

                    if (curr % (long) k == 0) {

                        ans++;
                    }
                }
            }
        }

        return ans;    
    }
}