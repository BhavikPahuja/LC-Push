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
    public int minScore(int n, int[][] roads) {
        
        DisjointSet ds = new DisjointSet(n);

        for (int road[] : roads) {

            ds.unionBySize(road[0], road[1]);
        }

        int ans = (int) 1e9;

        for (int road[] : roads) {

            if (ds.findParent(road[0]) == ds.findParent(1) || ds.findParent(road[1]) == ds.findParent(1)) {

                ans = Math.min(ans, road[2]);
            }
        }

        return ans;
    }
}