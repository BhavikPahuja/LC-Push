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
    public int largestIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        DisjointSet ds = new DisjointSet(n * m);
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    for (int dir[] : dirs) {
                        int r = i + dir[0], c = j + dir[1];
                        if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1) {
                            ds.unionBySize(i * m + j, r * m + c);
                        }
                    }
                }
            }
        }
        
        int ans = - (int) 1e9;
        for (int i=0; i<n*m; i++) {
            if (ds.parent[i] == i) {
                ans = Math.max(ans, ds.size[i]);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for (int dir[] : dirs) {
                        int r = i + dir[0], c = j + dir[1];
                        if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1) {
                            set.add(ds.findParent(r * m + c));
                        }
                    }
                    
                    int curr = 1;
                    for (int parent : set) {
                        curr += ds.size[parent];
                    }
                    
                    ans = Math.max(ans, curr);
                }
            }
        }
        return ans;
    }
}