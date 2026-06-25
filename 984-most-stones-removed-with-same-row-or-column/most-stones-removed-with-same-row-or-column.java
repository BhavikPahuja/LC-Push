class DisjointSet {
    int parent[];
    int size[];

    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i=0; i<n; i++) {
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
    public int removeStones(int[][] stones) {
        int n = stones.length;

        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        DisjointSet ds = new DisjointSet(n);

        for (int i=0; i<n; i++) {
            int x = stones[i][0], y = stones[i][1];

            if (rowMap.containsKey(x)) {
                ds.unionBySize(i, rowMap.get(x));
            }
            if (colMap.containsKey(y)) {
                ds.unionBySize(i, colMap.get(y));
            }

            rowMap.put(x, i);
            colMap.put(y, i);
        }

        int connectedCopms = 0;

        for (int i=0; i<n; i++) {
            if (ds.findParent(i) == i) {
                connectedCopms++;
            }
        }

        return n - connectedCopms;
    }
}