class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        boolean vis[][] = new boolean[n][n];
        vis[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            int w = curr[2];
            if (r == n-1 && c == n-1) {
                return w;
            }
            for (int i=-1; i<=1; i++) {
                for (int j=-1; j<=1; j++) {
                    int new_r = r + i;
                    int new_c = c + j;
                    if (new_r < 0 || new_r >= n || new_c < 0 || new_c >= n || vis[new_r][new_c]) continue;
                    if (grid[new_r][new_c] == 0) {
                        vis[new_r][new_c] = true;
                        q.offer(new int[]{new_r, new_c, w + 1});
                    }
                }
            }
        }
        return -1;
    }
}