class DisjointSet {
    private int size[];
    private int parent[];

    public DisjointSet(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i=0; i<=n; i++) {
            size[i] = 0;
            parent[i] = i;
        }
    }

    public int findParent(int node) {
        if (node == parent[node]) {
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
            size[parent_v] = size[parent_u] + size[parent_v];
        } else {
            parent[parent_v] = parent_u;
            size[parent_u] = size[parent_u] + size[parent_v];
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (isConnected[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }

        int count = 0;
        for (int i=0; i<n; i++) {
            if (ds.findParent(i) == i) {
                count++;
            }
        }

        return count;
    }
}