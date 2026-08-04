class DSU {

    int parent[];
    int size[];

    DSU(int n) {

        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i=0; i<=n; i++) {

            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int node) {

        if (parent[node] == node) {

            return node;
        }

        return parent[node] = findParent(parent[node]);
    }

    void unionBySize(int u, int v) {

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
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        DSU dsu = new DSU(n);

        for (int edge[] : edges) {

            dsu.unionBySize(edge[0], edge[1]);
        }

        return dsu.findParent(source) == dsu.findParent(destination);
    }
}