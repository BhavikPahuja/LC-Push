class DisjointSet {
    private List<Integer> size = new ArrayList<>();
    private List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i=0; i<=n; i++) {
            size.add(0);
            parent.add(i);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int parent_node = findParent(parent.get(node));
        parent.set(node, parent_node);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if (parent_u == parent_v) {
            return;
        }

        if (size.get(parent_u) < size.get(parent_v)) {
            parent.set(parent_u, parent_v);
            size.set(parent_v, size.get(parent_v) + size.get(parent_u));
        } else {
            parent.set(parent_v, parent_u);
            size.set(parent_u, size.get(parent_u) + size.get(parent_v));
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

        Set<Integer> count = new HashSet<>();
        for (int i=0; i<n; i++) {
            count.add(ds.findParent(i));
        }

        return count.size();
    }
}