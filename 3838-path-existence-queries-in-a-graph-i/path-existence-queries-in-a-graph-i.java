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
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        DisjointSet ds = new DisjointSet(n);

        for (int i=0; i<n-1; i++) {

            if (nums[i + 1] - nums[i] <= maxDiff) {

                ds.unionBySize(i, i + 1);
            }
        }

        int m = queries.length;
        boolean ans[] = new boolean[m];
        for (int i=0; i<m; i++) {

            if (ds.findParent(queries[i][0]) == ds.findParent(queries[i][1])) {

                ans[i] = true;
            }
        }

        return ans;
    }
}