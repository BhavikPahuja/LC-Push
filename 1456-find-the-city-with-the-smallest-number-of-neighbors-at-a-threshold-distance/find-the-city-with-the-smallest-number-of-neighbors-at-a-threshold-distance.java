class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int adj[][] = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                adj[i][j] = (int) 1e9;
                if (i == j) {
                    adj[i][j] = 0;
                }
            }
        }
        for (int edge[] : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u][v] = w;
            adj[v][u] = w;
        }
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
        int ans = n;
        int min = n;
        for (int i=0; i<n; i++) {
            int curr_min = 0;
            for (int j=0; j<n; j++) {
                if (adj[i][j] <= distanceThreshold) {
                    curr_min++;
                }
            }
            if (curr_min <= min) {
                min = curr_min;
                ans = i;
            }
        }
        return ans;
    }
}