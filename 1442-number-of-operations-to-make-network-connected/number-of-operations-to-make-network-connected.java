class DisjointSet {
    private int parent[];
    private int size[];

    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i=0; i<n; i++) {
            size[i] = 0;
            parent[i] = i;
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
            size[parent_v] = size[parent_u] + size[parent_v];
        } else {
            parent[parent_u] = parent_v;
            size[parent_v] = size[parent_u] + size[parent_v];
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        DisjointSet ds = new DisjointSet(n);

        for (int connection[] : connections) {
            int u = connection[0], v = connection[1];
            ds.unionBySize(u, v);
        }

        int count = 0;
        for (int i=0; i<n; i++) {
            if (ds.findParent(i) == i) {
                count++;
            }
        }

        return count - 1;
    }
}