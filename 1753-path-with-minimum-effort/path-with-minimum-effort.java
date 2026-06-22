class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int dist[][] = new int[n][m];
        for (int i=0; i<n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        q.offer(new int[]{0, 0, 0});
        while(!q.isEmpty()) {
            int curr[] = q.poll();
            int r = curr[0], c = curr[1], d = curr[2];
            int dr[] = {0, 1, 0, -1};
            int dc[] = {1, 0, -1, 0};
            for (int i=0; i<4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                int nd = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));
                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd;
                    q.offer(new int[]{nr, nc, nd});
                }
            }
        }
        return dist[n-1][m-1];
    }
}