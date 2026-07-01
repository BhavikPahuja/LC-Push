class DisjointSet {

    int parent[];
    int size[];

    public DisjointSet(int n) {

        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i=0; i<=n; i++) {

            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node) {

        if (parent[node] == node) {

            return node;
        }

        return parent[node] = findParent(parent[node]);
    }

    public void unionBySize(int u, int v) {

        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if (parent_u == parent_v) {

            return;
        }

        if (size[parent_u] < size[parent_v]) {

            parent[parent_u] = parent_v;
            size[parent_v] += size[parent_u];
        } else {

            parent[parent_v] = parent_u;
            size[parent_u] += size[parent_v];
        }
    }
}

class Solution {

    int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    boolean check(int dist[][], int val) {

        int n = dist.length;

        if (dist[0][0] < val || dist[n - 1][n - 1] < val) {

            return false;
        }

        DisjointSet ds = new DisjointSet(n * n);

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                if (dist[row][col] >= val) {

                    int idx1 = row * n + col;

                    for (int dir[] : dirs) {

                        int new_row = row + dir[0], new_col = col + dir[1];

                        if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < n && dist[new_row][new_col] >= val) {

                            int idx2 = new_row * n + new_col;

                            ds.unionBySize(idx1, idx2);
                        }
                    }
                }
            }
        }

        return ds.findParent(0) == ds.findParent((n - 1) * n + (n - 1));
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        
        int n = grid.size();

        int dist[][] = new int[n][n];
        for (int row[] : dist) {

            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for (int row=0; row<n; row++) {
            
            for (int col = 0; col<n; col++) {

                if (grid.get(row).get(col) == 1) {

                    dist[row][col] = 0;
                    q.offer(new int[]{row, col});
                }
            }
        }

        while (!q.isEmpty()) {

            int curr[] = q.poll();
            int row = curr[0], col = curr[1];

            for (int dir[] : dirs) {

                int new_row = row + dir[0], new_col = col + dir[1];

                if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < n && dist[new_row][new_col] == -1) {

                    dist[new_row][new_col] = dist[row][col] + 1;
                    q.offer(new int[]{new_row, new_col});
                }
            }
        }

        int ans = -1;
        int low = 0, high =  2 * n;

        while (low <= high) {

            int mid = (low + high) >>> 1;

            if (check(dist, mid)) {
                
                ans = mid;
                low = mid + 1;
            } else {

                high = mid - 1;
            }
        }

        return ans;
    }
}