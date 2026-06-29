class Solution {
    
    record State(int row, int col) {}

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int vis[][] = new int[n][m];
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    ans++;
                    Queue<State> q = new LinkedList<>();
                    q.offer(new State(i, j));
                    vis[i][j] = 1;
                    while (!q.isEmpty()) {
                        State curr = q.poll();
                        int r = curr.row(), c = curr.col();
                        int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                        for (int dir[] : dirs) {
                            int new_r = r + dir[0], new_c = c + dir[1];
                            if (new_r >= 0 && new_r < n && new_c >= 0 && new_c < m && vis[new_r][new_c] == 0 && grid[new_r][new_c] == '1') {
                                q.offer(new State(new_r, new_c));
                                vis[new_r][new_c] = 1;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}