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

    public boolean unionBySize(int u, int v) {

        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if (parent_u == parent_v) {
            return true;
        }

        if (size[parent_u] < size[parent_v]) {
            parent[parent_u] = parent_v;
            size[parent_v] += size[parent_u];
        } else {
            parent[parent_v] = parent_u;
            size[parent_u] += size[parent_v];
        }

        return false;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;

        DisjointSet ds = new DisjointSet(n);
        int ans[] = new int[2];

        for (int edge[] : edges) {
            int u = edge[0], v = edge[1];

            if (ds.unionBySize(u, v)) {
                ans = edge;
            }
        }

        return ans;
    }
}